package com.hachathon.backend_simulador_api.DTO;

import java.math.BigDecimal;

import jakarta.persistence.Column;

public class ProdutoDTO {

    private Integer codigo;
    private String nome;
    private BigDecimal taxa;
    private int minimoMeses;
    private Integer maximoMeses;
    private BigDecimal valorMinimo;
    private BigDecimal valorMaximo;
    
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public BigDecimal getTaxa() {
		return taxa;
	}
	
	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}
	
	public int getMinimoMeses() {
		return minimoMeses;
	}
	
	public void setMinimoMeses(int minimoMeses) {
		this.minimoMeses = minimoMeses;
	}
	
	public Integer getMaximoMeses() {
		return maximoMeses;
	}
	
	public void setMaximoMeses(Integer maximoMeses) {
		this.maximoMeses = maximoMeses;
	}
	
	public BigDecimal getValorMinimo() {
		return valorMinimo;
	}
	
	public void setValorMinimo(BigDecimal valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
	
	public BigDecimal getValorMaximo() {
		return valorMaximo;
	}
	
	public void setValorMaximo(BigDecimal valorMaximo) {
		this.valorMaximo = valorMaximo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
  
}
