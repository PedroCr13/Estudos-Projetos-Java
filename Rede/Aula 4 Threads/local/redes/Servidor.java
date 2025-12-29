package local.redes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */
public class Servidor extends Thread{
    
    private Socket conexao;
    
    public Servidor(Socket c) {
        this.conexao = c;
    }
    
    @Override
    public void run() {         
        try {
            ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());  
            
            Pessoa p = (Pessoa)entrada.readObject();
            System.out.println("Dados recebidos do cliente:  ");
            System.out.println("Nome: " + p.getNome()); 
            System.out.println("Idade: " + p.getIdade()); 

            DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
            saida.writeUTF("Dados recebidos corretamente!");
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(50000);
            System.out.println("Aguardando conexão...");
            while (true) {
                Socket conexao = servidor.accept();
                Servidor thread = new Servidor(conexao);
                thread.start();
            }
        }catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
