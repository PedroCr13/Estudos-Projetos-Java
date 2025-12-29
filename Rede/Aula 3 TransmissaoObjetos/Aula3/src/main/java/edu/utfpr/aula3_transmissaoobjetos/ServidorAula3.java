package edu.utfpr.aula3_transmissaoobjetos;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

// @author Pedro Cristovão Lopes Fogaça
public class ServidorAula3 {

    private static ServerSocket servidor;
    private static Socket conexao;
    private static ObjectInputStream entrada; // irá receber um objeto
    private static DataOutputStream saida; // irá retornar uma string ao cliente

    public static void main(String[] args) {
        try {
            servidor = new ServerSocket(52000); // portas altas
            System.out.println("Aguardando conexão...");
            conexao = servidor.accept(); // servidor fica aguardando conexao do cliente

            // Receber o objeto (objeto deve estar tanto do lado cliente quanto servidor)
            // a classe Pessoa deve implementar Serilizable
            entrada = new ObjectInputStream(conexao.getInputStream()); // conexão com o socket

            // Espera-se um objeto pessoa, deve se fazer o casting / tratar exceção "ClassNotException"
            Pessoa pessoa = (Pessoa) entrada.readObject();
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Idade: " + pessoa.getIdade());

            // Enviar confirmação que recebeu o objeto (neste exemplo retornará String)
            saida = new DataOutputStream(conexao.getOutputStream());
            saida.writeUTF("Objeto recebido!");

            //Fechar conexão
            conexao.close();
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.print("Erro: " + ex.getMessage());
        }
    }
}
