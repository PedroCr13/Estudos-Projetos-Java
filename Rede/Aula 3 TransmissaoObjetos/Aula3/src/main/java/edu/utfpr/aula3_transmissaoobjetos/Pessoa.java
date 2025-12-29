package edu.utfpr.aula3_transmissaoobjetos;

import java.io.Serializable;

/*
*  Importante: Esta classe será instanciada um objeto que transitará pela rede
*              deve obrigatóriamente implementar a interface Serializable
*              transformará o objeto em bytes
* */

// @author Pedro Cristovão Lopes Fogaça
public class Pessoa implements Serializable {

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome;
    private int idade;
}
