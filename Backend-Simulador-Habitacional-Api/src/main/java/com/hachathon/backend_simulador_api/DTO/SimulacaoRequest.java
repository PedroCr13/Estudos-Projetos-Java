package com.hachathon.backend_simulador_api.DTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public class SimulacaoRequest {
	
	@NotNull(message = "O campo valor solicitado é obrigatório")
    private BigDecimal valorSolicitado;
    
	@NotNull(message = "O campo prazo é obrigatório")
    private Integer prazo;
	
    public BigDecimal getValorSolicitado() {
		return valorSolicitado;
	}
	public void setValorSolicitado(BigDecimal valorSolicitado) {
		this.valorSolicitado = valorSolicitado;
	}
	public Integer getPrazo() {
		return prazo;
	}
	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}
    
}
