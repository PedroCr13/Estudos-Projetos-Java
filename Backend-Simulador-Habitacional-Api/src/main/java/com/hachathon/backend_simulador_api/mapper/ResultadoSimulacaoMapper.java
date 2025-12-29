package com.hachathon.backend_simulador_api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hachathon.backend_simulador_api.DTO.ParcelaDTO;
import com.hachathon.backend_simulador_api.DTO.ResultadoSimulacaoDTO;
import com.hachathon.backend_simulador_api.entity.h2.Parcela;
import com.hachathon.backend_simulador_api.entity.h2.ResultadoSimulacao;

@Component
public class ResultadoSimulacaoMapper {

	@Autowired
	private ParcelaMapper parcelaMapper;
	
	public ResultadoSimulacao toEntity(ResultadoSimulacaoDTO dto) {
		ResultadoSimulacao entity = new ResultadoSimulacao();
		entity.setTipo(dto.getTipo());
		
		//percorrer o array dos objetos parcela que estão na ResultadoSimulacao
		for (ParcelaDTO parcelaDTO : dto.getParcelas()) {
			Parcela parcela = parcelaMapper.toEntity(parcelaDTO);
			parcela.setResultadoSimulacao(entity);
			entity.getParcelas().add(parcela);
		}
		
		return entity;
	}
	
	public ResultadoSimulacaoDTO toDto(ResultadoSimulacao entity) {
		ResultadoSimulacaoDTO dto = new ResultadoSimulacaoDTO();
		dto.setTipo(entity.getTipo());
		
		List<ParcelaDTO> parcelasDTO = new ArrayList<>();
		for (Parcela parcela : entity.getParcelas()) {
			ParcelaDTO parcelaDTO = parcelaMapper.toDto(parcela);
			parcelasDTO.add(parcelaDTO);
		}
		
		dto.setParcelas(parcelasDTO);
		
		return dto;
	}
}
