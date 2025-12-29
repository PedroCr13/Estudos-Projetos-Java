package edu.utfpr.exemplo_servidor_thread;

import java.net.*;
import java.io.*;

/*
*  Permite receber multiplas conexões simultâneas
* */

public class ServerThread extends Thread {

    private Socket socket;

    public ServerThread(Socket conn) {
        this.socket = conn;
    }

    @Override
    public void run() {

        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());

            String mensagem = entrada.readUTF();
            mensagem = mensagem.toUpperCase();
            System.out.println("A mensagem em maiusculo e: " + mensagem);

            entrada.close();
            socket.close();

        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.toString());
        }
    }

    public static void main(String[] args) throws IOException {

        //instancia o servidor se a porta estiver livre
        ServerSocket servidor = new ServerSocket(54321);

        //laço infinito para servidor estar sempre disponível
        while(true) {

            //canal de comunicação aguardar requisição de conexão
            Socket conexao = servidor.accept();

            System.out.println("Um cliente se conectou...");

            //conexão é adicionada em uma nova thread
            ServerThread thread = new ServerThread(conexao);
            thread.start(); // inicia o metodo Run()
        }
    }
}
