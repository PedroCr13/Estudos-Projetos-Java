package local.redes;

import java.io.Serializable;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */
public class Candidato implements Serializable {
    private String nome;
    private int numeroDoPartido;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDoPartido() {
        return numeroDoPartido;
    }

    public void setNumeroDoPartido(int numeroDoPartido) {
        this.numeroDoPartido = numeroDoPartido;
    }
    
    @Override
    public String toString() {
        return numeroDoPartido + " " + nome;
    }
}
