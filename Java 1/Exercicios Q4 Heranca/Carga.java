package com.mycompany.listaexercicios;

/**
 *
 * @author Usuario
 */
final public class Carga extends Veiculo{
    
    private int tara;
    private int cargaMax;
    
    public Carga(){
        this.tara = 0;
        this.cargaMax = 0;
    }
    
    public int getTara(){
        return this.tara;
    }
    
    public int getCargaMax(){
        return this.cargaMax;
    }
    
    final public void setTara(int tara){
        this.tara = tara;
    }
    
    final public void setCargaMax(int cargaMax){
        this.cargaMax = cargaMax;
    }
    
    public double calcVel(int velocMax){
        return getVelocMax() * 100000;
    }
}
