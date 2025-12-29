package br.edu.utfpr.cp.espjava.crudcidades.cidade;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Criando entidade persistente

@Entity(name = "cidade")
public class CidadeEntidade implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String estado;

    public Long getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}


