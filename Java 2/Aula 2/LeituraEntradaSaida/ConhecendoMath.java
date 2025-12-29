/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caelum;

import java.lang.Math;

/**
 *
 * @author Usuario
 */
public class ConhecendoMath {
    
    public static void main(String args[]){
        double d = 4.6;
        long i = Math.round(d);
    
        int x = -4;
        int y = Math.abs(x);
    
        System.out.println("\n Arredondando 4.6: " + i);
        System.out.println("\n Absoluto -4: " + y);
        
    }
    
}
