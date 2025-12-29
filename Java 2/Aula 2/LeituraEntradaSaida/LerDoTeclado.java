/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caelum;

import java.io.*;

/**
 *
 * @author Usuario
 */
public class LerDoTeclado {
    
    public static void main(String args[]){
        
        InputStream is = System.in;
        //traduz os bytes em chars
        InputStreamReader isr = new InputStreamReader(is);
        //recebe um reader e concatena os chars para formar uma String
        BufferedReader br = new BufferedReader(isr);
        
        try{
            String s = br.readLine();
            /*
            while (s != null){
                System.out.println(s);
                s = br.readLine();
            }*/
          
            do{
                System.out.println(s);
                s = br.readLine();
            }while(s != null);
            
        }catch(IOException ioe){
            System.out.println("Erro: " + ioe.toString());
        }

    }
}
