package com.hachathon.backend_simulador_api.entity.sqlserver;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @Column(name="CO_PRODUTO", nullable = false)
    private Long codigo;

    @Column(name="NO_PRODUTO", nullable = false)
    private String nome;

    @Column(name="PC_TAXA_JUROS", precision = 10, scale = 9)
    private BigDecimal taxa;

    @Column(name="NU_MINIMO_MESES", nullable = false)
    private int minimoMeses;

    @Column(name="NU_MAXIMO_MESES")
    private Integer maximoMeses;

    @Column(name="VR_MINIMO", nullable = false)
    private BigDecimal valorMinimo;

    @Column(name="VR_MAXIMO")
    private BigDecimal valorMaximo;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

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
    
    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", taxa=" + taxa +
                ", minimoMeses=" + minimoMeses +
                ", maximoMeses=" + maximoMeses +
                ", valorMinimo=" + valorMinimo +
                ", valorMaximo=" + valorMaximo +
                '}';
    }

}
