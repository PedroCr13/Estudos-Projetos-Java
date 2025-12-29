//Pedro Cristovao Lopes Fogaca
package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {
    //Pedro Cristovao Lopes Fogaca
    public String entDados(String rotulo){
        //captura dados do teclado
        InputStreamReader teclado = new InputStreamReader(System.in);
        
        //armazena na memoria principal
        BufferedReader memoria = new BufferedReader(teclado);    
        String entrada = "";
        
        System.out.println(rotulo);
        try{
            //retorna os dados armazenados na memoria
           entrada = memoria.readLine();    
        } catch(IOException ioe){
            System.out.println("\n Erro no sistema");
        }
        return entrada;
    }    
}
