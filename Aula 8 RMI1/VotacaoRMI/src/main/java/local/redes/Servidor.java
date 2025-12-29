package local.redes;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */
public class Servidor extends UnicastRemoteObject implements MetodosRemotosUrna {
   
    private BancoDeVotos bancoDeVotos;
    
    public Servidor() throws RemoteException {
        super();
        bancoDeVotos = new BancoDeVotos();
    }

    @Override
    public void cadastrarCandidato(Candidato candidato) throws RemoteException, 
            CandidatoExisteException {
        bancoDeVotos.adicionarCandidato(candidato);
    }

    @Override
    public void registrarVotos(int numeroPartido, int quantidadeVotos) throws RemoteException {
        bancoDeVotos.adicionarVotos(numeroPartido, quantidadeVotos);
    }

    @Override
    public void atualizaApuracao() throws RemoteException {
        bancoDeVotos.exibirVotosPorCandidato();
    }
    
    public List<Candidato> obterListaDeCandidatos() {
        return bancoDeVotos.obterListaDeCandidatos();
    }
    
    public static void main(String[] args) {
        try {
            Registry servidorDeRegistro = LocateRegistry.createRegistry(1099);
            
            Servidor servidor = new Servidor();
            
            Naming.rebind("metodosUrnaRMI", servidor);
            
            System.out.println("Servidor de Apuração aguardando conexões...");
            
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                   try {
                        servidor.atualizaApuracao();
                   } catch (RemoteException ex) {
                        System.out.println("Ocorreu um erro: " + ex.getMessage());
                   }
                }
            }, 0, 5000);

        } catch (RemoteException ex) {
            System.out.println("Ocorreu exceção RemoteException: " + ex.getMessage());
        } catch (MalformedURLException ex) {
            System.getLogger(Servidor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
