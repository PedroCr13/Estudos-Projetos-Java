package manipula_texto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ManipulaTexto {
    
    private File arquivo;
    private BufferedReader entrada;
    private BufferedWriter saida;

    public void ManipulaTexto() {
        arquivo = null;
        entrada = null;
        saida = null;
    }

    public boolean criarArquivo() {
        JFileChooser selecionaArquivo = new JFileChooser();
        selecionaArquivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        int result = selecionaArquivo.showSaveDialog(null);
        
        if (result == JFileChooser.CANCEL_OPTION){
            return false;
        }
        arquivo = selecionaArquivo.getSelectedFile();
        
        System.out.println(arquivo.getName());
        
        if (arquivo == null || arquivo.getName().equals("")){
            JOptionPane.showMessageDialog(null, "Nome de arquivo inválido!", 
                        "Erro!", JOptionPane.ERROR_MESSAGE);
        } else { 
            try{
                if (arquivo.exists()){
                    System.out.println("Arquivo existe!");
                } else {
                    arquivo.createNewFile();
                    System.out.println("Arquivo não existe!");
                }
                
                return true;
                
            }catch(IOException ioe){
                JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo!", 
                            "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    private Object lerObjetoDoArquivo(){
        ObjectInputStream objetcInput = null;
        FileInputStream fileInput = null;
        Object lista = null;
        
        try{
            if (arquivo.exists() && (arquivo.canRead())){
                fileInput = new FileInputStream(arquivo);
                try{
                    objetcInput = new ObjectInputStream(fileInput);
                    lista = objetcInput.readObject();
                    return lista;
                } catch (ClassNotFoundException cnfe){
                    cnfe.printStackTrace();
                }
            } else {
                System.out.println("\nErro ao ler o arquivo!");
            }
        }catch(FileNotFoundException fnf){
            fnf.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return null;
    }
    
    public List<Cliente> abrirArquivo(){
        JFileChooser selecionaArquivo = new JFileChooser();
        selecionaArquivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        List<Cliente> clientesDoArquivo = new ArrayList<Cliente>();
        
        int result = selecionaArquivo.showOpenDialog(null);
        
        if (result == JFileChooser.CANCEL_OPTION){
            return null;
        }
        arquivo = selecionaArquivo.getSelectedFile();
        
        System.out.println(arquivo.getName());
        
        if (arquivo == null || arquivo.getName().equals("")){
            JOptionPane.showMessageDialog(null, "Nome de arquivo inválido!", 
                        "Erro!", JOptionPane.ERROR_MESSAGE);
        } else { 
           return clientesDoArquivo = (List<Cliente>)lerObjetoDoArquivo();
        }        
        return null;
    }
    
    public boolean salvaArquivo(List<Cliente> listaDeClientes){
       try{
           //verifica se tem arquivo gerado no atributo arquivo
           //se não, gera
           if ((this.arquivo == null)||(!this.arquivo.exists())){
               return criarArquivo();
           }

           //grava o array no arquivo definido no atributo arquivo
           if ((this.arquivo != null) && (this.arquivo.exists())){
               escreveObjetoNoArquivo(listaDeClientes, arquivo);
               return true;
           }
           
       }catch(IOException ioe){
           ioe.printStackTrace();
       }   
       return false;
   }
    
    private void escreveObjetoNoArquivo(Object o, File destino) throws IOException{
       
       ObjectOutputStream objectOutput  = null;
       FileOutputStream fileOutput = null;
       
       try {
           if(destino.exists() && destino.canWrite()){
               fileOutput = new FileOutputStream(destino);
               objectOutput = new ObjectOutputStream(fileOutput);
               
               objectOutput.writeObject(o);
               
               objectOutput.close();
               fileOutput.close();  
           }
           
       } catch (IOException ioe) {
           ioe.printStackTrace();
       }
   } 
    
    public void fecharArquivo(){
        try{
            if (entrada != null){
                entrada.close();
            } 
            if (saida != null){
                saida.close();
            }
        }catch(IOException ioe){
            JOptionPane.showMessageDialog(null, "Erro ao fechar arquivo!", "Erro",
                        JOptionPane.ERROR_MESSAGE);
        }
    }
}
