package com.hachathon.backend_simulador_api.DTO;

import java.util.List;

public class RelatorioSimulacaoPaginadoDTO {
    private int pagina;
    private long qtdRegistros;
    private int qtdRegistrosPagina;
    private List<RelatorioSimulacaoResponseDTO> registros;
    
	public int getPagina() {
		return pagina;
	}
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	public long getQtdRegistros() {
		return qtdRegistros;
	}
	public void setQtdRegistros(long qtdRegistros) {
		this.qtdRegistros = qtdRegistros;
	}
	public int getQtdRegistrosPagina() {
		return qtdRegistrosPagina;
	}
	public void setQtdRegistrosPagina(int qtdRegistrosPagina) {
		this.qtdRegistrosPagina = qtdRegistrosPagina;
	}
	public List<RelatorioSimulacaoResponseDTO> getRegistros() {
		return registros;
	}
	public void setRegistros(List<RelatorioSimulacaoResponseDTO> registros) {
		this.registros = registros;
	}
}
