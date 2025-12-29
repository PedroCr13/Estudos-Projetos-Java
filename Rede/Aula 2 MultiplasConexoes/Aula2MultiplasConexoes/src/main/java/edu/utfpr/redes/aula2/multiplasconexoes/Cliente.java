package edu.utfpr.redes.aula2.multiplasconexoes;

import java.io.*;
import java.net.Socket;

public class Cliente {

    private static Socket conexao;
    private static DataInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {
        try {
            conexao = new Socket("127.0.0.1", 50000);

            System.out.println("Digite uma frase:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String frase = br.readLine();

            saida = new DataOutputStream(conexao.getOutputStream());
            saida.writeUTF(frase);

            entrada = new DataInputStream(conexao.getInputStream());
            String resposta = entrada.readUTF();
            System.out.println("Resposta do servidor: " + resposta);

            conexao.close();
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
