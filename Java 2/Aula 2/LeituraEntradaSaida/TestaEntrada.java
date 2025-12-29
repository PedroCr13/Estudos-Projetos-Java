/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caelum;

/**
 *
 * @author Usuario
 */

import java.io.*;
        
        
public class TestaEntrada {
    
    public static void main(String args[]){
        
        try{
            //InputStream > Abstrata / FileInputStream > Concreta
            //Le em bytes
            InputStream is = new FileInputStream("D:\\ler.txt");
            
            //decodificador, traduzir os bytes lidos em caracteres (char)
            InputStreamReader isr = new InputStreamReader(is);
            
            //recebe um reader e concatena os chars para formar uma String
            BufferedReader br = new BufferedReader(isr);
           /*
            int b = is.read();
            int c = isr.read();
            String s = br.readLine(); 
            
            System.out.println("Lido InputStream: " + b);
            System.out.println("\nLido InputStreamRaader: " + c);
            System.out.println("\nLido BufferdReader: " + s);
          */
           
            System.out.println("\nLendo arquivo todo: \n");
            //laço para ler o arquivo todo
            //readLine() quando chega ao fim do arquivo, retorna um null
            String s = br.readLine(); // Primeira Linha
            
            while (s != null){
                System.out.println(s);
                s = br.readLine();
            }
            
            br.close();
            
        }
        catch(IOException ioe){
            System.out.println("Ocorreu Erro: " + ioe.toString());
        }
    }
    
}
