package com.mycompany.listaexercicios;

/**
 *
 * @author Usuario
 */
final public class Passeio extends Veiculo{
    
    private int qdtdePassageiros;
    
    public Passeio(){
        qdtdePassageiros = 0;
    }
    
    public int getQtdePassageiros(){
        return this.qdtdePassageiros;
    }
    
    final public void setQtdePassageiros(int qtdePassageiros){
        this.qdtdePassageiros = qtdePassageiros;
    }
    
    public double calcVel(int velocMax){
        return getVelocMax() * 1000;
    }  
}
