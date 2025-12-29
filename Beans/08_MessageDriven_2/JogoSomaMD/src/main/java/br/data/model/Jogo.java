package br.data.model;

import java.util.Random;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */
public class Jogo {
    private Usuario usuario;
    private int numeroA;
    private int numeroB;
    
    public Jogo(Usuario usuario) {
        this.usuario = usuario;
    }
   
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public int getNumeroA() {
        return numeroA;
    }

    public int getNumeroB() {
        return numeroB;
    }
    
    public void sorteiaNumeros() {
        Random gerador = new Random();
        numeroA = gerador.nextInt(10) + 1;
        numeroB = gerador.nextInt(10) + 1;
    }
    
    public boolean validaCalculo(int resposta) {
        if ((numeroA + numeroB) == resposta) {
            usuario.adicionaPontuacao();
            return true;
        }
         else 
           return false;
    }
}
