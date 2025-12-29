package local.redes;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import javax.swing.JTextArea;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */
public class BatePapo extends Thread{
    
    private String usuario = null;
    private InetAddress endereco;
    private int porta;
    private MulticastSocket socket;
    public JTextArea textAreaMensagemRecebida;
    
    public void conectar(String usuario, String endereco, int porta, JTextArea j) {
        try {
            this.usuario = usuario;
            this.endereco = InetAddress.getByName(endereco);
            this.porta = porta;
            this.textAreaMensagemRecebida = j;
            
            socket = new MulticastSocket();
            socket.joinGroup(new InetSocketAddress(endereco, porta), 
                       NetworkInterface.getByInetAddress(this.endereco));
            
            textAreaMensagemRecebida.append("Você se conectou no chat. \n");
            
            this.start();

        } catch (Exception ex) {
            textAreaMensagemRecebida.append("[ERRO!] " + ex.getLocalizedMessage() + "\n");
        }
    }
    
    public void desconectar() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.leaveGroup(new InetSocketAddress(endereco, porta), 
                       NetworkInterface.getByInetAddress(endereco));
                socket.close();
                textAreaMensagemRecebida.append("Você saiu do chat. ");
            }
        } catch (Exception ex) {
            textAreaMensagemRecebida.append("Erro ao desconectar do chat. " 
                    + ex.getMessage());
        }
    }
    
    public void run() {
        // Receber mensagens dos demais usuários
        try {
            byte[] msg = new byte[128];
            
            MulticastSocket conexao = new MulticastSocket(porta);
            conexao.joinGroup(new InetSocketAddress(endereco, porta), 
                       NetworkInterface.getByInetAddress(endereco));

            while (true) {
                DatagramPacket datagrama = new DatagramPacket(msg, msg.length);
                
                conexao.receive(datagrama);
                
                String mensagem = new String(datagrama.getData());
                
                if (!mensagem.contains(usuario + " diz: ")) {
                    textAreaMensagemRecebida.append(mensagem + "\n");
                }
                msg = new byte[128];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void enviarMensagem(String mensagem) {
        try {            
            if (mensagem.equalsIgnoreCase("Sair")){
                desconectar();
                return;
            }
            
            byte[] msg = new byte[128];
          
            textAreaMensagemRecebida.append("Você disse: " + mensagem + "\n");
            
            mensagem = usuario + " diz: " + mensagem;
            
            msg = mensagem.getBytes();

            DatagramPacket datagram = new DatagramPacket(msg, msg.length, 
                endereco, porta);
            socket.send(datagram);

        } catch (Exception ex) {
            textAreaMensagemRecebida.append("[ERRO!] " + ex.getMessage() + "\n");
        }
    } 
}
