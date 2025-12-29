package edu.utfpr.redes.aula2.atividadenaoobrigatoria;

import java.io.*;
import java.net.Socket;

public class Cliente {

    private static Socket conexao;
    private static DataInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {
        try {
            conexao = new Socket("127.0.0.1", 50000);

            while(true) {
                System.out.println("Digite uma mensagem: ");
                InputStreamReader input = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(input);
                String msg = br.readLine();

                saida = new DataOutputStream(conexao.getOutputStream());
                saida.writeUTF(msg);

                if (msg.equalsIgnoreCase("Sair")){
                    break;
                }
            }
            conexao.close();
        } catch(IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
