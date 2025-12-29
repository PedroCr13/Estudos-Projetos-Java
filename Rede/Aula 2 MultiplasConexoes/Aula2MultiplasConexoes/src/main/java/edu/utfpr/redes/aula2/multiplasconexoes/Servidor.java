package edu.utfpr.redes.aula2.multiplasconexoes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread{

    private Socket conexao;

    public Servidor() {

    }

    public Servidor(Socket c) {
        this.conexao = c;
    }

    @Override
    public void run() {
        try {
            System.out.println("Start...");
            DataInputStream entrada = new DataInputStream(conexao.getInputStream());
            String frase = entrada.readUTF();
            System.out.println("Recebida: " + frase);

            String novaFrase = frase.toUpperCase();
            DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
            saida.writeUTF(novaFrase);
            conexao.close();
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {

            while(true) {
                ServerSocket servidor = new ServerSocket(50000);
                System.out.println("Aguardando conexão...");
                Socket conexao = servidor.accept(); //retorna um socket
                Servidor tServidor = new Servidor(conexao);
                tServidor.start();
            }
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
