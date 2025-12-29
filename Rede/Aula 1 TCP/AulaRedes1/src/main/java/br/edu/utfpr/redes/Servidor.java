package br.edu.utfpr.redes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    private static ServerSocket servidor;
    private static Socket conexao;
    private static DataInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {

        try {
            System.out.println("Aguardando conexao...");
            //especificar uma porta e aguardar conexao
            servidor = new ServerSocket(55000);
            conexao = servidor.accept(); // fica parado aguardando conexao do cliente / enlace

            //receber dados do cliente
            int valor;

            entrada = new DataInputStream(conexao.getInputStream()); // retorna entrada que recebeu do socket
            valor = entrada.readInt();

            //realizar a verificação do valo recebido
            String resultado = "";
            if (valor > 0){
                resultado = "O valor é maior qu zero";
            } else {
                resultado = "O valor é menor ou igua a zero";
            }
            //retornar dados ao cliente
            saida = new DataOutputStream(conexao.getOutputStream()); //conexao com o socket para enviar informação ao cliente
            saida.writeUTF(resultado); //envia string ao cliente.

            //fechar a conexão
            conexao.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
