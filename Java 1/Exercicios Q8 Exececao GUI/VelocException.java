package classes;

//Pedro Cristovao

import javax.swing.JOptionPane;

public class VelocException extends Exception{
    
    public VelocException(){
        JOptionPane.showMessageDialog(null, "A velocidade máxima está fora dos limites brasileiros", "Atenção!", JOptionPane.ERROR_MESSAGE);
    }
    
    public Veiculo concertaVelocMax(Veiculo v, int velocMax){
        try{
            v.setVelocMax(velocMax);
        }
        catch(VelocException ve){
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a velocidade!", "Atenção!", JOptionPane.ERROR_MESSAGE);
        }
        return v;
    }
    
}
