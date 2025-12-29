package edu.utfpr.exemplo_servidor_simples;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {

        //estabelece conexão
        Socket conexao = new Socket("127.0.0.1", 54321);

        //Representa saída de dados (permite cliente enviar dados ao servidor)
        DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

        //ler dados do usuário via teclado:
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mensagem = br.readLine();

        // permite escrever no canal de envio dos dados
        saida.writeUTF(mensagem);

        // fecha canal principal e sub-canal
        saida.close();
        conexao.close();

    }
}
