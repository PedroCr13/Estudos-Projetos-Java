package br.edu.utfpr.rmi.exemploimplementacao1;

// Servidor de nomes

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author pedro
 */
public class Servidor implements IOlaMundo{
    
    @Override
    public String olaMundo() throws RemoteException {
        return "Olá mundo!";
    }
    
    public static void main(String[] args) {
        try {
            Registry servidorRegistro = LocateRegistry.createRegistry(1099);
            
            // Cria instancia do servidor
            Servidor servidor = new Servidor();
            
            // Comunicação remota de 1 para 1
            // objeto consigo ser passado de uma maquina para outra
            // porta 0 (o SO irá escolher a porta)
            // Skeleton vai responder as requisições do cliente
            IOlaMundo skeleton =(IOlaMundo)UnicastRemoteObject.exportObject(servidor, 0);
            
            // associa um nome string ao skeleton para o cliente poder encontrá-lo
            servidorRegistro.bind("olarmi", skeleton);
            
            System.out.println("Servidor iniciado...");
        } catch (RemoteException ex) {
            System.getLogger(Servidor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (AlreadyBoundException ex) {
            System.getLogger(Servidor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
