package com.hachathon.backend_simulador_api.mapper;

import org.springframework.stereotype.Component;

import com.hachathon.backend_simulador_api.DTO.ParcelaDTO;
import com.hachathon.backend_simulador_api.entity.h2.Parcela;

@Component
public class ParcelaMapper {
	
	public Parcela toEntity(ParcelaDTO dto) {
		Parcela entity = new Parcela();
		entity.setNumero(dto.getNumero());
		entity.setValorAmortizacao(dto.getValorAmortizacao());
		entity.setValorJuros(dto.getValorJuros());
		entity.setValorPrestacao(dto.getValorPrestacao());
		return entity;
	}
	
	public ParcelaDTO toDto(Parcela entity) {
		ParcelaDTO dto = new ParcelaDTO();
		dto.setNumero(entity.getNumero());
		dto.setValorAmortizacao(entity.getValorAmortizacao());
		dto.setValorJuros(entity.getValorJuros());
		dto.setValorPrestacao(entity.getValorPrestacao());
		return dto;
	}

}
