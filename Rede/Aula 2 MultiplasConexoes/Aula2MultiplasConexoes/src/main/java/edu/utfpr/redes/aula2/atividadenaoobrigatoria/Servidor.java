package edu.utfpr.redes.aula2.atividadenaoobrigatoria;

import java.io.DataInputStream;
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
        try{
            while(true) {
                System.out.println("Iniciando recebimento...");
                DataInputStream entrada = new DataInputStream(conexao.getInputStream());
                String mensagem = entrada.readUTF();
                System.out.println("Mensagem recebida: " + mensagem);

                if (mensagem.equalsIgnoreCase("Sair")){
                    conexao.close();
                }
            }
        } catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(50000);
            while(true) {
                System.out.println("Aguardando conexao...");
                Socket conexao = servidor.accept();
                Servidor tServidor = new Servidor(conexao);
                tServidor.start();
            }
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
