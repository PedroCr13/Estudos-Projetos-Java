package com.hachathon.backend_simulador_api.entity.h2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hachathon.backend_simulador_api.entity.sqlserver.Produto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "simulacao")
public class Simulacao {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

	@Column(name = "ID_PRODUTO")
    private Long produtoId;

	@Column(name = "NOME_PRODUTO")
	private String descricaoProduto;

    @Column(name = "DATA_SIMULACAO")
    private LocalDate dataSimulacao;

    @Column(name = "VR_DESEJADO")
    private BigDecimal valorDesejado;

    @Column(name = "VR_TOTAL_PRICE")
    private BigDecimal totalPrice;

    @Column(name = "VR_TOTAL_SAC")
    private BigDecimal totalSac;

    @Column(name = "PRAZO_DESEJADO")
    private Integer prazo;
    
	@Column(name = "TAXA", precision = 10, scale = 9)
    private BigDecimal taxaJuros;
    
    @OneToMany(mappedBy = "simulacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ResultadoSimulacao> resultados = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
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

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getTotalSac() {
		return totalSac;
	}

	public void setTotalSac(BigDecimal totalSac) {
		this.totalSac = totalSac;
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

	public List<ResultadoSimulacao> getResultados() {
		return resultados;
	}

	public void setResultados(List<ResultadoSimulacao> resultados) {
		this.resultados = resultados;
	} 
	
	@Override
	public String toString() {
	    return "Simulacao{" +
	            "id=" + id +
	            ", valorDesejado=" + valorDesejado +
	            ", prazo=" + prazo +
	            ", taxaJuros=" + taxaJuros +
	            ", totalPrice=" + totalPrice +
	            ", totalSac=" + totalSac +
	            '}';
	}
}
