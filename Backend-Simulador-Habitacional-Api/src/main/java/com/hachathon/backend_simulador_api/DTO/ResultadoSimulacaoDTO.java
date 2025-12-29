package com.hachathon.backend_simulador_api.DTO;

import java.util.List;

import com.hachathon.backend_simulador_api.enums.TipoSimulacao;

public class ResultadoSimulacaoDTO {
	
    private TipoSimulacao tipo; //"SAC" ou "Price"
    private List<ParcelaDTO> parcelas;
    
	public TipoSimulacao getTipo() {
		return tipo;
	}
	public void setTipo(TipoSimulacao tipo) {
		this.tipo = tipo;
	}
	public List<ParcelaDTO> getParcelas() {
		return parcelas;
	}
	public void setParcelas(List<ParcelaDTO> parcelas) {
		this.parcelas = parcelas;
	}
	
	@Override
	public String toString() {
	    return "ResultadoSimulacaoDTO{" +
	            "tipo='" + tipo + '\'' +
	            ", parcelas=" + (parcelas != null ? parcelas.size() : 0) +
	            '}';
	}

}
