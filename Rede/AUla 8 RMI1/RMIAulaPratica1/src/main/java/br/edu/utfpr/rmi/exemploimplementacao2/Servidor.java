package br.edu.utfpr.rmi.exemploimplementacao2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author pedro
 */
public class Servidor extends UnicastRemoteObject implements MetodosRemotos {
    
    // Quando herda UnicastRemoteObject é necessário no construtor fazer chamada
    // a construtor dequela classe base.
    public Servidor() throws RemoteException {
        super();
    }

    @Override
    public String exibeValor(int valor) throws RemoteException {
        return "valor recebido pelo servidor: " + valor;
    }
    
    public static void main(String[] args) {
        try {
            // Servidor de nomes:
            Registry servidorRegistro = LocateRegistry.createRegistry(1099);
            
            // Associar nome com implementação do servidor:
            // metodo rebind: se encontrar um nome igual ele derruba e coloca o nome associado
            // passa nome do metodo remoto e instancia do servidor para associar ao nome
            Naming.rebind("metodoRMI", new Servidor());
            System.out.println("Aguardando conexões...");
        } catch (RemoteException ex) {
            System.getLogger(Servidor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (MalformedURLException ex) {
            System.getLogger(Servidor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
