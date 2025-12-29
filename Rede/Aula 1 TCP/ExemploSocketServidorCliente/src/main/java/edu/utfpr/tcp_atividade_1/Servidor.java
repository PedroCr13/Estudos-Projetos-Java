package edu.utfpr.tcp_atividade_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//@author Pedro Cristovão lopes fogaça

public class Servidor extends Thread{

    private Socket socket;
    private String cpfRecebido = "";
    private String resultado;

    public Servidor(Socket conexao){
        this.socket = conexao;
    }

    @Override
    public void run() {
        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());

            cpfRecebido = entrada.readUTF();
            System.out.println("Recebido CPF: " + cpfRecebido);

            Validador v = new Validador(cpfRecebido);

            if (v.cpfValido()) {
                resultado = "Este cpf é válido.";
            } else {
                resultado = "Este cpf é inválido";
            }

            System.out.println("Respondendo resultado: " + resultado);
            saida.writeUTF(resultado);

            System.out.println("Fechando conexão.");
            entrada.close();
            saida.close();
            socket.close();
        } catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(50000);
            System.out.println("Servidor iniciado...");

            while(true){
                Socket conexao = serverSocket.accept();

                Servidor servidorThread = new Servidor(conexao);
                servidorThread.start();
            }
        } catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
        }
    }
}
