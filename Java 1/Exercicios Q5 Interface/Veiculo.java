//Pedro Cristovao Lopes Fogaca
package classes;

public abstract class Veiculo {
       
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private int qtdRodas;
    private int velocMax;
    private Motor motor;
    
    public Veiculo(){
        placa = "";
        marca = "";
        modelo= "";
        cor="";
        qtdRodas = 0;
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
    
    public String getCor(){
        return cor;
    }
    
    public int getQtdRodas(){
        return qtdRodas;
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
    
    final public void setCor(String cor){
        this.cor = cor;
    }
    
    final public void setQtdRodas(int qtdRodas){
        this.qtdRodas = qtdRodas;
    }
    
    final public void setVelocMax(int velocMax){
        this.velocMax = velocMax;
    }
    
    final public void setMotor (Motor motor){
        this.motor = motor;
    }
    
    public abstract double calcVel(int velocMax); 
}
