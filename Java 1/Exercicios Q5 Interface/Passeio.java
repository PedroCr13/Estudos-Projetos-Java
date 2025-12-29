//Pedro Cristovao Lopes Fogaca
package classes;

final public class Passeio extends Veiculo implements Calc{
    
    private int qdtdePassageiros;
    
    public Passeio(){
        qdtdePassageiros = 0;
    }
    
    final public int getQtdePassageiros(){
        return this.qdtdePassageiros;
    }
    
    final public void setQtdePassageiros(int qtdePassageiros){
        this.qdtdePassageiros = qtdePassageiros;
    }
    
    final public double calcVel(int velocMax){
        return getVelocMax() * 1000;
    } 
    
    final public int calcular(){
        //somar quantidade de letras
        String letras = getPlaca() + getMarca() + getModelo() + getCor();
        letras = letras.trim();  
        return letras.length();
    }
    
}
