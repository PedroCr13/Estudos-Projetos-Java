package com.hachathon.backend_simulador_api.DTO;

import java.math.BigDecimal;

public class ParcelaDTO {
	
    private Integer numero;
    private BigDecimal valorAmortizacao;
    private BigDecimal valorJuros;
    private BigDecimal valorPrestacao;
    
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public BigDecimal getValorAmortizacao() {
		return valorAmortizacao;
	}
	public void setValorAmortizacao(BigDecimal valorAmortizacao) {
		this.valorAmortizacao = valorAmortizacao;
	}
	public BigDecimal getValorJuros() {
		return valorJuros;
	}
	public void setValorJuros(BigDecimal valorJuros) {
		this.valorJuros = valorJuros;
	}
	public BigDecimal getValorPrestacao() {
		return valorPrestacao;
	}
	public void setValorPrestacao(BigDecimal valorPrestacao) {
		this.valorPrestacao = valorPrestacao;
	}

	@Override
	public String toString() {
	    return "ParcelaDTO{" +
	            "numero=" + numero +
	            ", valorAmortizacao=" + valorAmortizacao +
	            ", valorJuros=" + valorJuros +
	            ", valorPrestacao=" + valorPrestacao +
	            '}';
	}

}
