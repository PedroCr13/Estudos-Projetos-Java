package local.redes;

// @author Pedro Cristovão Lopes Fogaça

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private static ServerSocket servidor;
    private static Socket conexao;
    private static ObjectInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {
        try {
            servidor = new ServerSocket(50000);
            System.out.println("Aguardando conexão...");
            conexao = servidor.accept();

            entrada = new ObjectInputStream(conexao.getInputStream());

            Pessoa pessoa = (Pessoa)entrada.readObject();
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Idade: " + pessoa.getIdade());

            saida = new DataOutputStream(conexao.getOutputStream());
            saida.writeUTF("Dados recebidos com sucesso!");

            conexao.close();
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
