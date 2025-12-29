/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciorepita;

import javax.swing.JOptionPane;

/**
 *
 * @author notebook
 */
public class ExercicioRepita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //JOptionPane.showMessageDialog(null, "ola mundo!", "Boas Vindas", JOptionPane.WARNING_MESSAGE);        
       //int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um numero"));
        //JOptionPane.showMessageDialog(null, "O numero é " + n);   
        int n, s = 0;
        do {
           n = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um numero! (Valor 0 interrompe)", "Nunmeros", JOptionPane.INFORMATION_MESSAGE));
           s += n;
        } while (n != 0);
            
        JOptionPane.showMessageDialog(null, "Resultado final " + s, "Resultado!", JOptionPane.DEFAULT_OPTION);
        
    }
    
}
