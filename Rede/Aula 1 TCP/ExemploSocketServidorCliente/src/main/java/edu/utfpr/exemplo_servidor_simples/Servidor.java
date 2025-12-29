package edu.utfpr.exemplo_servidor_simples;

import java.net.*;
import java.io.*;

public class Servidor {

    public static void main(String[] args) throws IOException {

        //instancia servidor, se a porta estiver livre
        ServerSocket servidor = new ServerSocket(54321);

        System.out.println("A porta 54321 foi aberta.");

        //Esperar por uma requisição de conexão do cliente (metodo bloqueante)
        //canal de comunicação (socket)
        Socket conexao = servidor.accept();

        //Sub-canal de comunicação InputStream
        //canal de entrada de dados (neste exemplo apenas receberá dados)
        DataInputStream entrada = new DataInputStream(conexao.getInputStream());

        String mensagem = entrada.readUTF();
        mensagem = mensagem.toUpperCase();

        System.out.println("A mensagem em maisculo e: " + mensagem);

        //Recomendável fechar o canal (socket) e sub-canal (InputStream e/ OutputStream)
        //para liberar a porta para outra aplicação futura utilizar

        entrada.close();
        conexao.close();

    }
}
