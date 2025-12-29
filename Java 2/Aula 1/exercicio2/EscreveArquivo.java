package exercicio2;

import java.io.*;

public class EscreveArquivo {
    
    public String lerDados(){  
       InputStream is = System.in;
       InputStreamReader isr = new InputStreamReader(is);
       BufferedReader br = new BufferedReader(isr);
       String saida = "";
       
       try{
           saida = br.readLine();
       }catch(IOException ioe){
           System.out.println("\nOcorreu o erro: " + ioe.toString());
       }
       return saida;
       
    }
    
    public boolean verificaArquivo(String path){
        
        File arquivo = new File(path);
        
        if (arquivo.exists()){
            return true;
        } else {
            return false;
        }
    }
    
    public void criaArquivo(String path, String conteudo) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        bw.append(conteudo);
        bw.close();
    }
}
