//Pedro Cristovao Lopes Fogaca
package classes;

final public class Carga extends Veiculo implements Calc{
    
    private int tara;
    private int cargaMax;
    
    public Carga(){
        this.tara = 0;
        this.cargaMax = 0;
    }
    
    final public int getTara(){
        return this.tara;
    }
    
    final public int getCargaMax(){
        return this.cargaMax;
    }
    
    final public void setTara(int tara){
        this.tara = tara;
    }
    
    final public void setCargaMax(int cargaMax){
        this.cargaMax = cargaMax;
    }
    
    final public double calcVel(int velocMax){
        return getVelocMax() * 100000;
    }
    
    final public int calcular(){
        int numeros = getQtdRodas() + getVelocMax() + getMotor().getPotencia() +
                getMotor().getQtdPist();
        return 0;
    }
    
}
