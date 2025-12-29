package com.hachathon.backend_simulador_api.DTO;

import java.math.BigDecimal;

public class RelatorioSimulacaoResponseDTO {
	
	private Long idSimulacao;
	private BigDecimal valorDesejado;
	private Integer prazo;
	private BigDecimal valorTotalParcelasPrice;
	private BigDecimal valorTotalParcelasSac;
	
	public Long getIdSimulacao() {
		return idSimulacao;
	}
	public void setIdSimulacao(Long idSimulacao) {
		this.idSimulacao = idSimulacao;
	}
	public BigDecimal getValorDesejado() {
		return valorDesejado;
	}
	public void setValorDesejado(BigDecimal valorDesejado) {
		this.valorDesejado = valorDesejado;
	}
	public Integer getPrazo() {
		return prazo;
	}
	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}
	public BigDecimal getValorTotalParcelasPrice() {
		return valorTotalParcelasPrice;
	}
	public void setValorTotalParcelasPrice(BigDecimal valorTotalParcelasPrice) {
		this.valorTotalParcelasPrice = valorTotalParcelasPrice;
	}
	public BigDecimal getValorTotalParcelasSac() {
		return valorTotalParcelasSac;
	}
	public void setValorTotalParcelasSac(BigDecimal valorTotalParcelasSac) {
		this.valorTotalParcelasSac = valorTotalParcelasSac;
	}
}
