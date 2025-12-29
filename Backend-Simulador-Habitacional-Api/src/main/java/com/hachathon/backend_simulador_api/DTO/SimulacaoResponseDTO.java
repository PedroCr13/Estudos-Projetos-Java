package com.hachathon.backend_simulador_api.DTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SimulacaoResponseDTO {
	
	private Long idSimulacao;
    private Long codigoProduto;
    private String descricaoProduto;
    private BigDecimal taxaJuros;
	
    private List<ResultadoSimulacaoDTO> resultadoSimulacao = new ArrayList<>();

	public Long getIdSimulacao() {
		return idSimulacao;
	}

	public void setIdSimulacao(Long idSimulacao) {
		this.idSimulacao = idSimulacao;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public BigDecimal getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(BigDecimal taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	public List<ResultadoSimulacaoDTO> getResultadoSimulacao() {
		return resultadoSimulacao;
	}

	public void setResultadoSimulacao(List<ResultadoSimulacaoDTO> resultadoSimulacao) {
		this.resultadoSimulacao = resultadoSimulacao;
	}
}
