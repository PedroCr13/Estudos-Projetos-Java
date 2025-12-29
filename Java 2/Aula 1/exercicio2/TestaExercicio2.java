package exercicio2;

import java.io.IOException;

public class TestaExercicio2 {
    
    public static void main(String args[]){
        
        EscreveArquivo arquivo = new EscreveArquivo();
       
        String nomeDeArquivo = "";
        String sequenciaPalavras = "";
       
        System.out.println("\nDigite um nome de arquivo: ");
        nomeDeArquivo = arquivo.lerDados();

        System.out.println("\nDigite uma sequencia de palavras: ");
        sequenciaPalavras = arquivo.lerDados();

        if (arquivo.verificaArquivo(nomeDeArquivo)){
            System.out.println("\nArquivo existe!");
        } else {
            try{
               arquivo.criaArquivo(nomeDeArquivo, sequenciaPalavras);
            }catch(IOException ioe){
                System.out.println("\nOcorreu o erro: " + ioe.toString());
            }
        }
           
        
    }
    
}
