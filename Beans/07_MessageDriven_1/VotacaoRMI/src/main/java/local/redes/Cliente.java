package local.redes;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */
 public class Cliente {
    
    private MetodosRemotosUrna stub;
    
    public Cliente() throws RemoteException, NotBoundException, MalformedURLException {
        conectar();
    }
    
    public void conectar() throws RemoteException, NotBoundException, MalformedURLException {
        stub = (MetodosRemotosUrna) Naming.lookup("rmi://127.0.0.1/metodosUrnaRMI");
    }
    
    public void desconectar() {
        stub = null;
    }
    
    public void cadastrarCandidato(Candidato candidato) throws RemoteException, 
            CandidatoExisteException{
         stub.cadastrarCandidato(candidato);
    }
    
    public void registrarVotos(int numeroPartido, int quantidadeVotos)  
            throws RemoteException
    {
        stub.registrarVotos(numeroPartido, quantidadeVotos);
    }
    
    public List<Candidato> obterListaDeCandidatos() throws RemoteException {
        List<Candidato> lista = new ArrayList<>();
        lista = stub.obterListaDeCandidatos();
        return lista;
    }
}
