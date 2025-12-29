package br.edu.utfpr.rmi.exemploimplementacao1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author pedro
 */

// Interface compartilhada entre servidor e cliente
// caso esteja em maquinas diferentes cada um deve ter uma interface igual a esta

public interface IOlaMundo extends Remote{
    public String olaMundo() throws RemoteException;
}
