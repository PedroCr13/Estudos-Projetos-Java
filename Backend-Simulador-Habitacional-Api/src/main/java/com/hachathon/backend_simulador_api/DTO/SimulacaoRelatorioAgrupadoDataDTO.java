package com.hachathon.backend_simulador_api.DTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class SimulacaoRelatorioAgrupadoDataDTO {
	
    private LocalDate dataReferencia;
    private Long codigoProduto;
    private String descricaoProduto;
    private BigDecimal taxaMediaJuro;
    private BigDecimal valorMedioPrestacaoSac;
    private BigDecimal valorMedioPrestacaoPrice;
    private BigDecimal valorTotalDesejado;
    private BigDecimal totalCreditoSac;
    private BigDecimal totalCreditoPrice;
	
	public LocalDate getDataReferencia() {
		return dataReferencia;
	}
	public void setDataReferencia(LocalDate dataReferencia) {
		this.dataReferencia = dataReferencia;
	}
	public Long getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public BigDecimal getTaxaMediaJuro() {
		return taxaMediaJuro.setScale(4, RoundingMode.HALF_UP);
	}
	public void setTaxaMediaJuro(BigDecimal taxaMediaJuro) {
		this.taxaMediaJuro = taxaMediaJuro;
	}
	public BigDecimal getValorMedioPrestacaoSac() {
		return valorMedioPrestacaoSac.setScale(2, RoundingMode.HALF_UP);
	}
	public void setValorMedioPrestacaoSac(BigDecimal valorMedioPrestacaoSac) {
		this.valorMedioPrestacaoSac = valorMedioPrestacaoSac;
	}
	public BigDecimal getValorMedioPrestacaoPrice() {
		return valorMedioPrestacaoPrice.setScale(2, RoundingMode.HALF_UP);
	}
	public void setValorMedioPrestacaoPrice(BigDecimal valorMedioPrestacaoPrice) {
		this.valorMedioPrestacaoPrice = valorMedioPrestacaoPrice;
	}
	public BigDecimal getValorTotalDesejado() {
		return valorTotalDesejado.setScale(2, RoundingMode.HALF_UP);
	}
	public void setValorTotalDesejado(BigDecimal valorTotalDesejado) {
		this.valorTotalDesejado = valorTotalDesejado;
	}
	public BigDecimal getTotalCreditoSac() {
		return totalCreditoSac;
	}
	public void setTotalCreditoSac(BigDecimal totalCreditoSac) {
		this.totalCreditoSac = totalCreditoSac;
	}
	public BigDecimal getTotalCreditoPrice() {
		return totalCreditoPrice;
	}
	public void setTotalCreditoPrice(BigDecimal totalCreditoPrice) {
		this.totalCreditoPrice = totalCreditoPrice;
	}

}
