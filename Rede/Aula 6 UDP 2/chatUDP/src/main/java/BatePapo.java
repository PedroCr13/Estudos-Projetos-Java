
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

/**
 *
 * @author pedro
 */
public class BatePapo extends Thread{
    
    private static String usuario = null;
    private static InetAddress endereco;
    private static int porta;
    
    public void run() {
        // Receber mensagens dos demais usuários
        try {
            // Cria um array de bytes
            byte[] msg = new byte[128];
            
            // Como esta thread esta recebendo PRECISA da porta.
            MulticastSocket conexao = new MulticastSocket(porta);
            conexao.joinGroup(new InetSocketAddress(endereco, porta), 
                    NetworkInterface.getByInetAddress(endereco));
            
            // Vai receber mensanges eternamente 
            while (true) {
                // Para receber datagram não precisa do endereco
                DatagramPacket datagrama = new DatagramPacket(msg, msg.length);
                
                // permanece em situação bloqueante:
                conexao.receive(datagrama);
                
                // trasnforma o datagrama em string
                String mensagem = new String(datagrama.getData());
                
                // Multiscast todos usuarios recebem a mensagem, inclusive quem enviou
                // tratar para ser exibida apenas a mensagem que não contem 
                // o usuario que esta enviado: usuario + " diz"
                if (!mensagem.contains(usuario + " diz: ")) {
                    System.out.println("\n" + mensagem);
                    System.out.print("Digite a mensagem: ");
                }
                
                msg = new byte[128];
   
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Aplicação vai receber parametros endereços 
    // Todos os clientes estarão atrelados ao endereço multicast
    // Todos poderão enviar e receber mensagens
    public static void main(String[] args) {
        
        // Esta é a thread princial (envia mensagens)
        
        // Recebera 2 parâmetros pela linha de comando (args) (endereço e porta)
        if (args.length != 2) {
            System.out.println("Os parâmetros estão incorretos!");
            System.out.println("java BatePapo <endereco_multicast><porta>");
            // Manda sinal que programa encerrou com algum problema. (0 nenhum)
            System.exit(1); 
        }
        try {
            // pegar endereço e porta que serão usados.
            endereco = InetAddress.getByName(args[0]);
            porta = Integer.parseInt(args[1]);
            
            // Executar Thread para receber informações dos outros usuários
            BatePapo bp = new BatePapo();
            bp.start();
            
            // Enviar mensagens para os demais usuários
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite seu nome: ");
            usuario = br.readLine();
            
            // Criar objeto multicast para usar faixa de endereco multicast
            // MultcastSocket para receber e enviar datagramas para se comunicar com demais usuarios
            // Como esta enviado informaçoes para outros usuarios Não precisa definir a porta
            // (para receber precisa, lá na thread)
            MulticastSocket conexao = new MulticastSocket();
            
            // Associacao da placa de rede com o multicast:
            // passa o endereco, porta e o endereco multiscast
            conexao.joinGroup(new InetSocketAddress(endereco, porta), 
                       NetworkInterface.getByInetAddress(endereco));
            
            byte[] msg = new byte[128];
            
            // Servidor sempre executando serviço (laço true)
            while(true) {
                System.out.println("Digite a mensage: ");
                String mensagem = br.readLine();
                
                if (mensagem.equals("Sair")) {
                    // Sair com código 0 (sem erros)
                    System.exit(0); 
                }
                
                // Enviar mensagem para outros usuarios:
                mensagem = usuario + " diz: " + mensagem;
                
                // Para enviar via UDP precisa trasnformar mensagem em array de bytes
                msg = mensagem.getBytes();
                
                // Armazenar em datagrama (colocar mensagem, tamanho da mensage, endereo e porta
                DatagramPacket datagram = new DatagramPacket(msg, msg.length, 
                    endereco, porta);
                conexao.send(datagram);
                
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
