package classes;

//Pedro Cristovao Lopes Fogaca
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {

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
        } catch (NumberFormatException nfe){
            System.out.println("\n Valor inválido!");
        }
        return entrada;
    }    
}
