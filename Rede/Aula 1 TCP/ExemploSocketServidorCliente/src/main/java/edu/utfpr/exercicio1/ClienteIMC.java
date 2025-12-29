package edu.utfpr.exercicio1;

import java.net.*;
import java.io.*;

public class ClienteIMC {

    public static void main(String[] args) {

        int peso;
        double altura, resultado;

        try {
            //estabelece conexão:
            Socket conexao = new Socket("127.0.0.1", 54321);

            //canal de entrada e saída de dados (envio/recebimento do servidor)
            DataInputStream entrada = new DataInputStream(conexao.getInputStream());
            DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

            //processamento
            peso = 93;
            altura = 1.68;

            //envio
            System.out.println("Enviando peso e altura ao servidor...");
            saida.writeInt(peso);
            saida.writeDouble(altura);

            resultado = entrada.readDouble();

            System.out.println("IMC calculado pelo servidor: " + resultado);

            //fecha canal e subcanal
            saida.close();
            conexao.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
