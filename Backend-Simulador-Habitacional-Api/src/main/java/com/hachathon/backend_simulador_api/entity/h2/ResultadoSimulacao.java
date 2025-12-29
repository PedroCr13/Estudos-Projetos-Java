package com.hachathon.backend_simulador_api.entity.h2;

import java.util.ArrayList;
import java.util.List;

import com.hachathon.backend_simulador_api.enums.TipoSimulacao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "resultado_simulacao")
public class ResultadoSimulacao {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_SIMULACAO", nullable = false)
    private Simulacao simulacao;

    @OneToMany(mappedBy = "resultadoSimulacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parcela> parcelas = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO") 
    private TipoSimulacao tipo; //SAC ou PRICE

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Simulacao getSimulacao() {
		return simulacao;
	}

	public void setSimulacao(Simulacao simulacao) {
		this.simulacao = simulacao;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public TipoSimulacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoSimulacao tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
	    return "ResultadoSimulacao{" +
	            "id=" + id +
	            ", tipo='" + tipo + '\'' +
	            ", parcelas=" + parcelas.size() +
	            '}';
	}
}
