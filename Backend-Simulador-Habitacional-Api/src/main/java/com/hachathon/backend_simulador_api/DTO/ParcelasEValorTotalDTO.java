package com.hachathon.backend_simulador_api.DTO;

import java.math.BigDecimal;
import java.util.List;

public class ParcelasEValorTotalDTO {

	private List<ParcelaDTO> parcelas;
	private BigDecimal valorTotalParcelas;
	
	public List<ParcelaDTO> getParcelas() {
		return parcelas;
	}
	public void setParcelas(List<ParcelaDTO> parcelas) {
		this.parcelas = parcelas;
	}
	public BigDecimal getValorTotalParcelas() {
		return valorTotalParcelas;
	}
	public void setValorTotalParcelas(BigDecimal totalParcelas) {
		this.valorTotalParcelas = totalParcelas;
	}	
}
