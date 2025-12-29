package classes;

//Pedro
public class VelocException extends Exception{
    
    public VelocException(){
        System.out.println("\nA velocidade máxima está fora dos limites brasileiros\n");
    }
    
    public Veiculo concertaVelocMax(Veiculo v, int velocMax){
        try{
            v.setVelocMax(velocMax);
        }
        catch(VelocException ve){
            System.out.println("\nNão foi possível alterar a velocidade");
        }
        return v;
    }
    
}
