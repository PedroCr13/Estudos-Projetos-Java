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
public class TesteSaida {
    
    public static void main(String[] args) {
        
        try{
            
            OutputStream os = new FileOutputStream("D:\\Saida.txt", true);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            
            bw.write("Caelum");
            bw.close();
           
        }catch(IOException ioe){
            System.out.println("Erro: " + ioe.toString());
        }
    }
    
}
