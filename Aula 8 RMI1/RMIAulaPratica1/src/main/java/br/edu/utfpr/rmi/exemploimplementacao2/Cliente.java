package br.edu.utfpr.rmi.exemploimplementacao2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author pedro
 */
public class Cliente {
    
    public static void main(String[] args) {
        try {
            // Criar stub:
            MetodosRemotos stub = (MetodosRemotos) Naming.lookup("rmi://127.0.0.1/metodoRMI");
       
            // Chama metodo remoto implementado no servidor:
            System.out.println("Executando metodo no servidor: " + stub.exibeValor(50));
        } catch (NotBoundException ex) {
            System.getLogger(Cliente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (MalformedURLException ex) {
            System.getLogger(Cliente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (RemoteException ex) {
            System.getLogger(Cliente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
