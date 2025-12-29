package local.redes;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */
public interface MetodosRemotosUrna extends Remote {
   
    public void cadastrarCandidato(Candidato candidato) throws RemoteException, 
            CandidatoExisteException;
    public List<Candidato> obterListaDeCandidatos() throws RemoteException;
    public void registrarVotos(int numeroPartido, int quantidadeVotos) 
            throws RemoteException;
    public void atualizaApuracao() throws RemoteException;
}
