package br.edu.utfpr.rmi.exemploimplementacao2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author pedro
 */
public interface MetodosRemotos extends Remote {
    
    // Metodo que será implementado no servidor
    // Eesta interface será compartilhada entre cliente e servidor.
    // Em maquinas separadas cada um terá uma interface igual esta
    public String exibeValor(int valor) throws RemoteException;
}
