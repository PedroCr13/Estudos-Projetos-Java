package local.redes.objjetoudp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Exemplo com Thread servidor UDP (datagramSocket - conexão e DatagramPacket - pacote)
 * @author Pedro Cristovão Lopes Fogaça
 */
public class Servidor {
    
    private static DatagramSocket conexao;
    private static DatagramPacket datagrama;
    
    private static ByteArrayInputStream entradaStream;
    private static ObjectInputStream entrada;
    
    // irá retornar resposta após 5 segundos (para testar se o cliente não fica com iterface bloqueada)
    public static void tempo() {
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException ex) {
            System.out.println("Erro: " + ex.getMessage()); 
        }
    }
    
    public static void main(String[] args) {      
        try {
            conexao = new DatagramSocket(50000);
            
            while (true){
                System.out.println("Aguardando conexão...");

                datagrama = new DatagramPacket(new byte [1024], 1024);
                conexao.receive(datagrama);

                // trasnforma o array de bytes recebido em objeto
                entradaStream = new ByteArrayInputStream(datagrama.getData());
                entrada = new ObjectInputStream(entradaStream);

                Pessoa p = (Pessoa) entrada.readObject();
                System.out.println("Nome: " + p.getNome());
                System.out.println("Idade: " + p.getIdade());

                String mensagem = "Dados recebidos corretamente!";
                byte[] resposta = mensagem.getBytes();

                datagrama = new DatagramPacket(resposta, resposta.length, 
                        datagrama.getAddress(), datagrama.getPort());
                tempo();
                conexao.send(datagrama);    
            }
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());         
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }         
    }
}
