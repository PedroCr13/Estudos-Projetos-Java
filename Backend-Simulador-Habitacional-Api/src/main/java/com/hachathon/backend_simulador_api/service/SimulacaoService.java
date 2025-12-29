package com.hachathon.backend_simulador_api.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hachathon.backend_simulador_api.DTO.ParcelaDTO;
import com.hachathon.backend_simulador_api.DTO.ParcelasEValorTotalDTO;
import com.hachathon.backend_simulador_api.DTO.RelatorioSimualacaoAgrupadoDataResponseDTO;
import com.hachathon.backend_simulador_api.DTO.RelatorioSimulacaoPaginadoDTO;
import com.hachathon.backend_simulador_api.DTO.RelatorioSimulacaoResponseDTO;
import com.hachathon.backend_simulador_api.DTO.ResultadoSimulacaoDTO;
import com.hachathon.backend_simulador_api.DTO.SimulacaoDTO;
import com.hachathon.backend_simulador_api.DTO.SimulacaoRelatorioAgrupadoDataDTO;
import com.hachathon.backend_simulador_api.DTO.SimulacaoRequest;
import com.hachathon.backend_simulador_api.DTO.SimulacaoResponseDTO;
import com.hachathon.backend_simulador_api.entity.h2.Parcela;
import com.hachathon.backend_simulador_api.entity.h2.ResultadoSimulacao;
import com.hachathon.backend_simulador_api.entity.h2.Simulacao;
import com.hachathon.backend_simulador_api.entity.sqlserver.Produto;
import com.hachathon.backend_simulador_api.enums.TipoSimulacao;
import com.hachathon.backend_simulador_api.excepitons.CamposVazioException;
import com.hachathon.backend_simulador_api.excepitons.PrazoNaoDiponivelException;
import com.hachathon.backend_simulador_api.excepitons.ProdutoIndisponivelException;
import com.hachathon.backend_simulador_api.h2.repository.SimulacaoRepository;
import com.hachathon.backend_simulador_api.integration.azure.EventHubSender;
import com.hachathon.backend_simulador_api.mapper.SimulacaoMapper;

@Service
public class SimulacaoService {

    private final SimulacaoRepository simulacaoRepository;
	
	@Autowired	
	private ProdutoService produtoService;
	
	@Autowired
	private SimulacaoMapper simulacaoMapper;
	
    @Autowired
    private EventHubSender eventHubSender;

    SimulacaoService(SimulacaoRepository simulacaoRepository) {
        this.simulacaoRepository = simulacaoRepository;
    }
	
	public SimulacaoResponseDTO criarSimulacao(SimulacaoRequest request) throws ProdutoIndisponivelException, 
		PrazoNaoDiponivelException{

		List<Produto> produtoAdequado = produtoService.buscarProdutosPeloValorSolicitado(request.getValorSolicitado());	
		
		if (produtoAdequado.isEmpty()) {
		    throw new ProdutoIndisponivelException("Produto não disponível pelo valor solicitado.");
		} 

		Produto produtoSelecionado = produtoAdequado.get(0);
		
		if (request.getPrazo() <= 0) {
			throw new PrazoNaoDiponivelException("Prazo deve ser maior que zero.");
		}
		
		Integer prazoMinimoProduto = produtoSelecionado.getMinimoMeses();
		Integer prazoMaximoProduto = produtoSelecionado.getMaximoMeses();
		
		if (prazoMaximoProduto != null) {
			if (request.getPrazo() < prazoMinimoProduto ||
			    request.getPrazo() > prazoMaximoProduto) {
				throw new PrazoNaoDiponivelException("Prazo inválido. Para este valor está definido " +
					"prazo minimo é " + prazoMinimoProduto + " meses e " +
					"prazo máximo é " + prazoMaximoProduto + " meses");
			} 
		}
		else
		if (prazoMaximoProduto == null) {
			if (request.getPrazo() <  prazoMinimoProduto) {
				throw new PrazoNaoDiponivelException("Prazo inválido. Para este valor está definido " +
					"prazo minimo é " + prazoMinimoProduto + " meses.");
			}
		}
		
		SimulacaoDTO simulacaoTemp = montaSimulacaoCompleta(produtoSelecionado, request);
		
		Simulacao simulacaoSalva = salvarSimulacaoCompleta(simulacaoTemp);
		
		SimulacaoResponseDTO simulacaoResponse = simulacaoMapper.toDtoResponse(simulacaoSalva);
		
		eventHubSender.enviarJSON(simulacaoResponse);

		return simulacaoResponse;
	} 
	
    public RelatorioSimulacaoPaginadoDTO gerarRelatorioSimulacoes(int pagina, int qtdRegistrosPagina) {
        Pageable pageable = PageRequest.of(pagina, qtdRegistrosPagina);
        Page<Simulacao> simulacoesPage = simulacaoRepository.findAll(pageable);

        List<RelatorioSimulacaoResponseDTO> dto = simulacoesPage.getContent().stream()
            .map(simulacaoMapper::toDtoRelatorioSimulacaoResponse)
            .toList();

        RelatorioSimulacaoPaginadoDTO relatorio = new RelatorioSimulacaoPaginadoDTO();
        relatorio.setPagina(pagina);
        relatorio.setQtdRegistros(simulacoesPage.getTotalElements());
        relatorio.setQtdRegistrosPagina(qtdRegistrosPagina);
        relatorio.setRegistros(dto);

        return relatorio;
    }
    
	public List<RelatorioSimualacaoAgrupadoDataResponseDTO> gerarRelatorioSimulacoesAgrupadoChaveData(
			List<SimulacaoRelatorioAgrupadoDataDTO> listaSimulacoes){
		
		Map<LocalDate, List<SimulacaoRelatorioAgrupadoDataDTO>> agrupado = listaSimulacoes.stream()
				.collect(Collectors.groupingBy(SimulacaoRelatorioAgrupadoDataDTO::getDataReferencia));
		
		List<RelatorioSimualacaoAgrupadoDataResponseDTO> resposta = new ArrayList<>();
		
		for (Map.Entry<LocalDate, List<SimulacaoRelatorioAgrupadoDataDTO>> entry : agrupado.entrySet()) {
			RelatorioSimualacaoAgrupadoDataResponseDTO dto = new RelatorioSimualacaoAgrupadoDataResponseDTO();
			dto.setDataReferencia(entry.getKey());
			dto.setSimulacoes(entry.getValue());
			resposta.add(dto);
		}
		
		return resposta;
	}
    
    public List<SimulacaoRelatorioAgrupadoDataDTO> gerarRelatorioSimulacaoAgrupadoData() {
    	
    	List<Object[]> resultados = simulacaoRepository.listarSimulacoesDataAgrupadasPorData();

    	List<SimulacaoRelatorioAgrupadoDataDTO> relatorio = new ArrayList<>();
    	
    	for (Object[] linha : resultados) {
    		SimulacaoRelatorioAgrupadoDataDTO dto = new SimulacaoRelatorioAgrupadoDataDTO();
    		
    		java.sql.Date sqlDate = ((java.sql.Date) linha[0]);
    		if (sqlDate != null) {
    			dto.setDataReferencia(sqlDate.toLocalDate());
    		}
    		
    		dto.setCodigoProduto((Long) linha[1]);
    		dto.setDescricaoProduto((String) linha[2]);
    		dto.setTaxaMediaJuro((BigDecimal) linha[3]);
    		dto.setValorTotalDesejado((BigDecimal) linha[4]);
    		dto.setValorMedioPrestacaoSac((BigDecimal) linha[5]);
    		dto.setValorMedioPrestacaoPrice((BigDecimal) linha[6]);
    		dto.setTotalCreditoPrice((BigDecimal) linha[7]);
    		dto.setTotalCreditoSac((BigDecimal) linha[8]);
    		
        	relatorio.add(dto);
    	}
    	
    	return relatorio;
    }
	
	private SimulacaoDTO montaSimulacaoCompleta(Produto produtoSelecionado, SimulacaoRequest request) {	
		SimulacaoDTO simulacao = new SimulacaoDTO();
		simulacao.setDataSimulacao(LocalDate.now());
		simulacao.setCodigoProduto(produtoSelecionado.getCodigo());
		simulacao.setDescricaoProduto(produtoSelecionado.getNome());
		simulacao.setTaxaJuros(produtoSelecionado.getTaxa().setScale(4, RoundingMode.HALF_UP));
		simulacao.setValorDesejado(request.getValorSolicitado());
		simulacao.setPrazo(request.getPrazo());
		
		ResultadoSimulacaoDTO resultadoSimulacaoSac = new ResultadoSimulacaoDTO();
		resultadoSimulacaoSac.setTipo(TipoSimulacao.SAC);
		
		ParcelasEValorTotalDTO parcelasValorTotalSac = calcularParcelasSac(request.getValorSolicitado(), request.getPrazo(), 
				produtoSelecionado);		
		resultadoSimulacaoSac.setParcelas(parcelasValorTotalSac.getParcelas());
			
		ResultadoSimulacaoDTO resultadoSimulacaoPrice = new ResultadoSimulacaoDTO();
		resultadoSimulacaoPrice.setTipo(TipoSimulacao.PRICE);
		
		ParcelasEValorTotalDTO parcelasValorTotalPrice = calcularParcelasPrice(request.getValorSolicitado(), request.getPrazo(), 
				produtoSelecionado);		
		resultadoSimulacaoPrice.setParcelas(parcelasValorTotalPrice.getParcelas());
		
		simulacao.getResultadoSimulacao().add(resultadoSimulacaoSac);
		simulacao.getResultadoSimulacao().add(resultadoSimulacaoPrice);

		simulacao.setTotalSac(parcelasValorTotalSac.getValorTotalParcelas());
		simulacao.setTotalPrice(parcelasValorTotalPrice.getValorTotalParcelas());
		
		return simulacao;
	}
	
	private ParcelasEValorTotalDTO calcularParcelasSac(BigDecimal valor, Integer prazo, Produto produto) {
        List<ParcelaDTO> parcelas = new ArrayList<>();
        BigDecimal amortizacao = valor.divide(BigDecimal.valueOf(prazo), 2, RoundingMode.HALF_UP);
        BigDecimal saldoDevedor = valor;
        BigDecimal totalParcelas = BigDecimal.ZERO;

        for (int i = 1; i <= prazo; i++) {
            BigDecimal juros = saldoDevedor.multiply(produto.getTaxa());

            BigDecimal prestacao = amortizacao.add(juros);

            ParcelaDTO parcela = new ParcelaDTO();
            parcela.setNumero(i);
            parcela.setValorAmortizacao(amortizacao.setScale(2, RoundingMode.HALF_UP));
            parcela.setValorJuros(juros.setScale(2, RoundingMode.HALF_UP));
            parcela.setValorPrestacao(prestacao.setScale(2, RoundingMode.HALF_UP));

            parcelas.add(parcela);

            saldoDevedor = saldoDevedor.subtract(amortizacao);
            
            totalParcelas = totalParcelas.add(prestacao);
        }
        
        //retorno do calculo com as parcelas e o valor total somado
        ParcelasEValorTotalDTO parcelasValorTotal = new ParcelasEValorTotalDTO();
        parcelasValorTotal.setParcelas(parcelas);
        parcelasValorTotal.setValorTotalParcelas(totalParcelas.setScale(2, RoundingMode.HALF_UP));
        
        return parcelasValorTotal;
    }
	
	private ParcelasEValorTotalDTO calcularParcelasPrice(BigDecimal valor, Integer prazoProduto, Produto produto) {

        List<ParcelaDTO> parcelas = new ArrayList<>();
        BigDecimal saldoDevedor = valor;
        BigDecimal totalParcelas = BigDecimal.ZERO;
        int n = prazoProduto;

        //Taxa de juros mensal como BigDecimal
        BigDecimal taxa = produto.getTaxa();
        BigDecimal umMaisTaxa = BigDecimal.ONE.add(taxa);

        //Fator de cálculo: (1 + taxa)^n
        BigDecimal fator = umMaisTaxa.pow(n);

        //Prestação fixa: valor * taxa / (1 - (1 + taxa)^-n)
        BigDecimal prestacaoFixa = valor.multiply(taxa).multiply(fator)
                .divide(fator.subtract(BigDecimal.ONE), 10, RoundingMode.HALF_UP);

        for (int i = 0; i < prazoProduto; i++) {
            ParcelaDTO parcela = new ParcelaDTO();

            //Juros do período: saldoDevedor * taxa
            BigDecimal valorJuros = saldoDevedor.multiply(taxa).setScale(2, RoundingMode.HALF_UP);

            //Amortização: prestação - juros
            BigDecimal valorAmortizacao = prestacaoFixa.subtract(valorJuros).setScale(2, RoundingMode.HALF_UP);

            //Prestação: valor fixo
            BigDecimal valorPrestacao = prestacaoFixa.setScale(2, RoundingMode.HALF_UP);

            //Atualiza saldo devedor
            saldoDevedor = saldoDevedor.subtract(valorAmortizacao);

            parcela.setNumero(i + 1);
            parcela.setValorAmortizacao(valorAmortizacao.setScale(2, RoundingMode.HALF_UP));
            parcela.setValorJuros(valorJuros.setScale(2, RoundingMode.HALF_UP));
            parcela.setValorPrestacao(valorPrestacao.setScale(2, RoundingMode.HALF_UP));	
            
            parcelas.add(parcela);
            
            totalParcelas = totalParcelas.add(valorPrestacao);
        }
        
        ParcelasEValorTotalDTO parcelasValorTotal = new ParcelasEValorTotalDTO();
        parcelasValorTotal.setParcelas(parcelas);
        parcelasValorTotal.setValorTotalParcelas(totalParcelas.setScale(2, RoundingMode.HALF_UP));

        return parcelasValorTotal;
    }
	
	private Simulacao salvarSimulacaoCompleta(SimulacaoDTO dto) {
		Simulacao simulacao = simulacaoMapper.toEntity(dto);
		
	    //Setar vínculos bidirecionais
	    for (ResultadoSimulacao resultado : simulacao.getResultados()) {
	        resultado.setSimulacao(simulacao);
	        for (Parcela parcela : resultado.getParcelas()) {
	            parcela.setResultadoSimulacao(resultado);
	        }
	    }    

		return simulacaoRepository.save(simulacao);
	}
		
}
