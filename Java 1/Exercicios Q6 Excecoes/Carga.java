package classes;

//Pedro Cristovao Lopes Fogaca
public final class Carga extends Veiculo implements Calc{
    
    private int tara;
    private int cargaMax;
    
    public Carga(){
        this.tara = 0;
        this.cargaMax = 0;
    }
    
    public final int getTara(){
        return this.tara;
    }
    
    public final int getCargaMax(){
        return this.cargaMax;
    }
    
    public final void setTara(int tara){
        this.tara = tara;
    }
    
    public final void setCargaMax(int cargaMax){
        this.cargaMax = cargaMax;
    }
    
    public final double calcVel(){
        return getVelocMax() * 10000;
    }
    
    public final int calcular(){
        int numeros = getQtdRodas() + getVelocMax() + getTara() + getMotor().getPotencia() +
                getMotor().getQtdPist();
        return numeros;
    }
    
}
