package br.edu.utfpr.redes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    private static Socket conexao; // para criar conexao com o servidor, precisara de iP e porta do server

    private static DataInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {
        try {
            // conectar com o servidor
            conexao = new Socket("127.0.0.1", 55000);

            // enviar um numero inteiro
            saida = new DataOutputStream(conexao.getOutputStream());
            int numero = 10;
            saida.writeInt(numero);

            // receber resposta do servidor
            entrada = new DataInputStream(conexao.getInputStream());
            String resposta = entrada.readUTF();
            System.out.println("Respostas do servidor: " + resposta);

            //fechar conexão
            conexao.close();
        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
