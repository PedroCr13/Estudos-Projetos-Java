package classes;

//Pedro Cristovao Lopes Fogaca
public final class Passeio extends Veiculo implements Calc{
    
    private int qdtdePassageiros;
    
    public Passeio(){
        qdtdePassageiros = 0;
    }
    
    public final int getQtdePassageiros(){
        return this.qdtdePassageiros;
    }
    
    public final void setQtdePassageiros(int qtdePassageiros){
        this.qdtdePassageiros = qtdePassageiros;
    }
    
    public final double calcVel(){
        return getVelocMax() * 1000;
    } 
    
    public final int calcular(){
        //somar quantidade de letras
        String letras = getPlaca() + getMarca() + getModelo() + getCor();
        letras = letras.trim();  
        return letras.length();
    }
    
}
