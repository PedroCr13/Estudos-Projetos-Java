package com.hachathon.backend_simulador_api.entity.h2;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "parcela")
public class Parcela {
	
    @Id
    @Column(name = "ID_PARCELA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_RESULTADO_SIMULACAO", nullable = false)
    private ResultadoSimulacao resultadoSimulacao;

    @Column(name = "NUM_PARCELA")
    private Integer numero;

    @Column(name = "VALOR_AMORTIZACAO")
    private BigDecimal valorAmortizacao;

    @Column(name = "VALOR_JUROS")
    private BigDecimal valorJuros;

    @Column(name = "VALOR_PRESTACAO")
    private BigDecimal valorPrestacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ResultadoSimulacao getResultadoSimulacao() {
		return resultadoSimulacao;
	}

	public void setResultadoSimulacao(ResultadoSimulacao resultadoSimulacao) {
		this.resultadoSimulacao = resultadoSimulacao;
	}

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
	    return "Parcela{" +
	            "id=" + id +
	            ", numero=" + numero +
	            ", valorAmortizacao=" + valorAmortizacao +
	            ", valorJuros=" + valorJuros +
	            ", valorPrestacao=" + valorPrestacao +
	            '}';
	}
}
