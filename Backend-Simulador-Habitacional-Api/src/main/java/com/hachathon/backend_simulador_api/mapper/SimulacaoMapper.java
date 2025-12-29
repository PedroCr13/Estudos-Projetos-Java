package com.hachathon.backend_simulador_api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hachathon.backend_simulador_api.DTO.RelatorioSimulacaoResponseDTO;
import com.hachathon.backend_simulador_api.DTO.ResultadoSimulacaoDTO;
import com.hachathon.backend_simulador_api.DTO.SimulacaoDTO;
import com.hachathon.backend_simulador_api.DTO.SimulacaoResponseDTO;
import com.hachathon.backend_simulador_api.entity.h2.ResultadoSimulacao;
import com.hachathon.backend_simulador_api.entity.h2.Simulacao;

@Component 
public class SimulacaoMapper {
	
	@Autowired
	private ResultadoSimulacaoMapper resultadoSimulacaoMapper;
	
	public SimulacaoDTO toDto(Simulacao entity) {
		SimulacaoDTO dto = new SimulacaoDTO();
		dto.setIdSimulacao(entity.getId());
		dto.setCodigoProduto(entity.getProdutoId());
		dto.setDescricaoProduto(entity.getDescricaoProduto());
		dto.setTaxaJuros(entity.getTaxaJuros());
		dto.setDataSimulacao(entity.getDataSimulacao());
		dto.setValorDesejado(entity.getValorDesejado());
		dto.setPrazo(entity.getPrazo());
		dto.setTotalPrice(entity.getTotalPrice());
		dto.setTotalSac(entity.getTotalSac());
		
		List<ResultadoSimulacaoDTO> resultadosDTO = new ArrayList<>();
		for (ResultadoSimulacao resultado : entity.getResultados()) {
			resultadosDTO.add(resultadoSimulacaoMapper.toDto(resultado));
		}
		
		dto.setResultadoSimulacao(resultadosDTO);
		
		return dto;
	}
	
	public Simulacao toEntity(SimulacaoDTO dto) {
		Simulacao entity = new Simulacao();
		entity.setProdutoId(dto.getCodigoProduto());
		entity.setDescricaoProduto(dto.getDescricaoProduto());
		entity.setTaxaJuros(dto.getTaxaJuros());
		entity.setDataSimulacao(dto.getDataSimulacao());
		entity.setValorDesejado(dto.getValorDesejado());
		entity.setPrazo(dto.getPrazo());
		entity.setTotalPrice(dto.getTotalPrice());
		entity.setTotalSac(dto.getTotalSac());
		
		for (ResultadoSimulacaoDTO resultadoSimulacaoDTO : dto.getResultadoSimulacao()) {
			ResultadoSimulacao resultadoSimulacao = resultadoSimulacaoMapper.toEntity(resultadoSimulacaoDTO);
			resultadoSimulacao.setSimulacao(entity);
			entity.getResultados().add(resultadoSimulacao);
		}
		
		return entity;
	}
	
	public SimulacaoResponseDTO toDtoResponse(Simulacao entity) {
		SimulacaoResponseDTO dto = new SimulacaoResponseDTO();
		dto.setIdSimulacao(entity.getId());
		dto.setCodigoProduto(entity.getProdutoId());
		dto.setDescricaoProduto(entity.getDescricaoProduto());
		dto.setTaxaJuros(entity.getTaxaJuros());

		List<ResultadoSimulacaoDTO> resultadosDTO = new ArrayList<>();
		for (ResultadoSimulacao resultado : entity.getResultados()) {
			resultadosDTO.add(resultadoSimulacaoMapper.toDto(resultado));
		}
		
		dto.setResultadoSimulacao(resultadosDTO);
		
		return dto;
	}
	
	public RelatorioSimulacaoResponseDTO toDtoRelatorioSimulacaoResponse(Simulacao entity) {
		RelatorioSimulacaoResponseDTO dto = new RelatorioSimulacaoResponseDTO();
		dto.setIdSimulacao(entity.getId());
		dto.setValorDesejado(entity.getValorDesejado());
		dto.setPrazo(entity.getPrazo());
		dto.setValorTotalParcelasPrice(entity.getTotalPrice());
		dto.setValorTotalParcelasSac(entity.getTotalSac());
		return dto;
	}
}
