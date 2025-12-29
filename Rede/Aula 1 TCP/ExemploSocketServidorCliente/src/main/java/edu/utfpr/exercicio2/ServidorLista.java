package edu.utfpr.exercicio2;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorLista {

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(54326);
            Socket conexao = servidor.accept();
            ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
            try {

                while (true) {
                    Pessoa p = (Pessoa) entrada.readObject();
                    System.out.println("Nome: " + p.getNome());
                    System.out.println("Cpf: " + p.getCpf());
                    System.out.println("Idade: " + p.getIdade());
                }

            } catch (ClassNotFoundException cne) {
                System.out.println("Erro: " + cne.getMessage());
            }
            entrada.close();
            conexao.close();
        } catch (EOFException eoe) {
            System.out.println("Fim de recebimento: " + eoe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Erro de I/O: " + ioe.getMessage());
        }
    }
}
