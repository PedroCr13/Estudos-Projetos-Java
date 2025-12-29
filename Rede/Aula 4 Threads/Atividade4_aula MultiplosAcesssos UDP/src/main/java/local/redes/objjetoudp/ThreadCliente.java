package local.redes.objjetoudp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author pedro
 */
public class ThreadCliente implements Runnable {
    
    /* 
     atributos onde serão recebidos as referencias do formulário 
     em que poderão ser alteradas
    */
    private String nome;
    private int idade;
    private JTextArea jTArea;
    
    private DatagramSocket conexao;
    private DatagramPacket datagrama;
   
    // envio de objeto
    private ByteArrayOutputStream saidaStream;
    private ObjectOutputStream saida;
    
    // private DataOutputStream saida;
    
    // Recebe as referências, as alterações irão refletir no Form
    public ThreadCliente(String nome, int idade, JTextArea j) {
        this.nome = nome;
        this.idade = idade;
        this.jTArea = j;
    }
    
    @Override
    public void run() {
        try {
            conexao = new DatagramSocket(); // não precisa informar porta no cliente
            Pessoa p = new Pessoa();
            // valor dos atributos vieram pelo contrutor
            p.setNome(nome); 
            p.setIdade(idade);
            
            saidaStream = new ByteArrayOutputStream();
            saida = new ObjectOutputStream(saidaStream);
            saida.writeObject(p);
            
            // passa o objeto pessoa para array de bytes
            byte[] dados = saidaStream.toByteArray();
            
            // Envia para o servidor: (args: array de bytes, tamanho, ip e porta
            DatagramPacket pacoteEnviado = new DatagramPacket(dados, dados.length, 
                    InetAddress.getByName("127.0.0.1"), 50000);
            
            conexao.send(pacoteEnviado);
            
            // Aguarda resposta do servidor, cria array para armazenar resposta recebida
            datagrama = new DatagramPacket(new byte[120], 120);
            conexao.receive(datagrama); // fica aguardando resposta (estado bloqueante)
            String respostaServidor = new String(datagrama.getData());
            
            // Exibir resposta no textArea, acrescentando após ultima linha:
            jTArea.append(respostaServidor + "\n");
            
        } catch (SocketException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
