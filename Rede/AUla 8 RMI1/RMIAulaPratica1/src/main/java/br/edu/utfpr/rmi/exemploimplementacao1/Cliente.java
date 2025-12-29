package br.edu.utfpr.rmi.exemploimplementacao1;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author pedro
 */

// Classe cliente (Rmi):
public class Cliente {
       
    public static void main(String[] args) {
        try {
            // Irá procurar a string nome e ter acesso ao servidor de nomes
            // Criar acesso ao servidor de nomes
            // utiliza o getRegistry passando o IP e a porta para procura
            Registry servidorRegistro = LocateRegistry.getRegistry("127.0.0.1", 1099);
            
            // após fazer o enlace com servidor de nomes acima, irá verificar se tem acesso ao servidor 
            // objeto stub faá a comunicação com o servidor
            IOlaMundo stub = (IOlaMundo)servidorRegistro.lookup("olarmi");
            
            // usa stub como objeto local, o RMI irá enviar msg ao servidor e trazer a resposta
            System.out.println("Resposta do servidor: " + stub.olaMundo());
        } catch (RemoteException ex) {
            System.getLogger(Cliente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (NotBoundException ex) {
            System.getLogger(Cliente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
