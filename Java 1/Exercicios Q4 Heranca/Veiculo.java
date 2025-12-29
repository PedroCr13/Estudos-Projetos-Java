package com.mycompany.listaexercicios;

/**
 *
 * @author Usuario
 */
public abstract class Veiculo {
    
    private String placa;
    private String marca;
    private String modelo;
    private int velocMax;
    private Motor motor;
    
    public Veiculo(){
        placa = "";
        marca = "";
        modelo= "";
        velocMax = 0;
        motor = new Motor();
    }
    
    public String getPlaca(){
        return placa;
    }
                
    public String getMarca (){
        return marca;
    }
                
    public String getModelo (){
        return modelo;
    }
                
    public int getVelocMax(){
        return velocMax;
    }
                
    public Motor getMotor(){
        return motor;
    }
    
    final public void setPlaca (String placa){
        this.placa = placa;
    }
    
    final public void setMarca (String marca){
        this.marca = marca;
    }
    
    final public void setModelo (String modelo){
        this.modelo = modelo;
    }
    
    final public void setVelocMax(int velocMax){
        this.velocMax = velocMax;
    }
    
    final public void setMotor (Motor motor){
        this.motor = motor;
    }
    
    public abstract double calcVel(int velocMax);
}
