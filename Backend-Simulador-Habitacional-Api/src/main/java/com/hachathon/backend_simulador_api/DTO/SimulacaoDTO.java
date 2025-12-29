package com.hachathon.backend_simulador_api.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SimulacaoDTO {
	
	private Long idSimulacao;
    private Long codigoProduto;
    private String descricaoProduto;
    private LocalDate dataSimulacao;
    private BigDecimal valorDesejado;
    private Integer prazo;
	private BigDecimal taxaJuros;
	private BigDecimal totalSac;
	private BigDecimal totalPrice;
    
    private List<ResultadoSimulacaoDTO> resultadoSimulacaoDTO = new ArrayList<>();

	public Long getIdSimulacao() {
		return idSimulacao;
	}
	public void setIdSimulacao(Long idSimulacao) {
		this.idSimulacao = idSimulacao;
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
    public LocalDate getDataSimulacao() {
		return dataSimulacao;
	}
	public void setDataSimulacao(LocalDate dataSimulacao) {
		this.dataSimulacao = dataSimulacao;
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
	public BigDecimal getTaxaJuros() {
		return taxaJuros;
	}
	public void setTaxaJuros(BigDecimal taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	public List<ResultadoSimulacaoDTO> getResultadoSimulacao() {
		return resultadoSimulacaoDTO;
	}
	public void setResultadoSimulacao(List<ResultadoSimulacaoDTO> resultadoSimulacaoDTO) {
		this.resultadoSimulacaoDTO = resultadoSimulacaoDTO;
	}
	public BigDecimal getTotalSac() {
		return totalSac;
	}
	public void setTotalSac(BigDecimal totalSac) {
		this.totalSac = totalSac;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
