package br.data.model;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */
public class Usuario {
    private String nome;
    private int pontuacao;

    public Usuario() {
        this.pontuacao = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void adicionaPontuacao() {
        this.pontuacao++;
    }
}
