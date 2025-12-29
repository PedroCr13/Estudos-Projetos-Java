package edu.utfpr.exercicio1;

import javax.imageio.IIOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorIMC {

    public static void main(String[] args) {

        double altura = 0;
        int peso = 0;
        double imc = 0;

        try {
            //instanciar o servidor
            ServerSocket servidor = new ServerSocket(54321);

            //abrir canal de comunicação para aguardar conexão
            Socket conexao = servidor.accept();
            System.out.println("Aguardadndo conexão...");

            //abrir subcanal para entrada de dados
            DataInputStream entrada = new DataInputStream(conexao.getInputStream());
            DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

            //fazer o processamento
            peso = entrada.readInt();
            altura = entrada.readDouble();

            System.out.println("Recebido Peso: " + peso);
            System.out.println("Recebida Altura: " + altura);

            imc = peso / (altura * altura);

            System.out.println("IMC calculado: " + imc);

            saida.writeDouble(imc);

            //fechar canal e subcanal de processamento
            entrada.close();
            conexao.close();
        } catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
        }
    }
}
