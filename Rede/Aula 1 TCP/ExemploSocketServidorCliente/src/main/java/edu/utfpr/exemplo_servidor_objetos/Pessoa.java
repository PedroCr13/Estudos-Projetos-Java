package edu.utfpr.exemplo_servidor_objetos;

import java.io.Serializable;

/*
*  Implementar classe com Serialible, pois o objeto Pessoa
*  será transmitido como stream
* */

public class Pessoa implements Serializable {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    };

    public int getIdade() {
        return idade;
    }
}
