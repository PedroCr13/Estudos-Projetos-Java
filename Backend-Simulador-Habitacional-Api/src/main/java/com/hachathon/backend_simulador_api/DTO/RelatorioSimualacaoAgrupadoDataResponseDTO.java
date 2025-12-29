package com.hachathon.backend_simulador_api.DTO;

import java.time.LocalDate;
import java.util.List;

public class RelatorioSimualacaoAgrupadoDataResponseDTO {
	
	private LocalDate dataReferencia;
	private List<SimulacaoRelatorioAgrupadoDataDTO> simulacoes;
	
	public RelatorioSimualacaoAgrupadoDataResponseDTO() {
		
	}
	
	public RelatorioSimualacaoAgrupadoDataResponseDTO(LocalDate dataReferencia,
			List<SimulacaoRelatorioAgrupadoDataDTO> simulacoes) {
		super();
		this.dataReferencia = dataReferencia;
		this.simulacoes = simulacoes;
	}
	
	public LocalDate getDataReferencia() {
		return dataReferencia;
	}
	public void setDataReferencia(LocalDate dataReferencia) {
		this.dataReferencia = dataReferencia;
	}
	public List<SimulacaoRelatorioAgrupadoDataDTO> getSimulacoes() {
		return simulacoes;
	}
	public void setSimulacoes(List<SimulacaoRelatorioAgrupadoDataDTO> simulacoes) {
		this.simulacoes = simulacoes;
	}

}
