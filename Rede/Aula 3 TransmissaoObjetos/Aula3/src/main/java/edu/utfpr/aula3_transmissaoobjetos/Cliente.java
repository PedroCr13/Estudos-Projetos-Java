package edu.utfpr.aula3_transmissaoobjetos;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

// @author Pedro Cristovão Lopes Fogaça
/*
*  Cliente irá criar uma instancia da classe Pessoa e enviar ao Servidor
*  ficará aguardando o recebimento de uma String.
* */
public class Cliente {

    private static Socket conexao;
    private static ObjectOutputStream saida; // Enviará um objeto Pessoa
    private static DataInputStream entrada; // Receberá uma string do Servidor

    public static void main(String[] args) {
        try {
            conexao = new Socket("127.0.0.1", 50000);
            // se passou pelo conexao significa que já está conectado com o servidor e podem trocar dados
            Pessoa p = new Pessoa();
            p.setNome("Pedro Cristovão");
            p.setIdade(34);
            saida = new ObjectOutputStream(conexao.getOutputStream());
            saida.writeObject(p);

            //Receber resposta do servidor:
            entrada = new DataInputStream(conexao.getInputStream());
            String resposta = entrada.readUTF();
            System.out.println("Resposta do Servidor: " + resposta);

            // Fechar a conexão:
            conexao.close();
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
