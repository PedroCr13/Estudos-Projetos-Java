package local.redes;

import java.io.*;
import java.net.*;

//@author Pedro Cristovão lopes fogaça

public class Cliente {

    public static void main(String[] args) {

        String cpf, resultado;

        try {
            Socket conexao = new Socket("127.0.0.1", 50000);

            DataInputStream entrada = new DataInputStream(conexao.getInputStream());
            DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite um CPF para verificação: ");
            cpf = br.readLine();

            saida.writeUTF(cpf);

            resultado = entrada.readUTF();

            System.out.println("Resultado: " + resultado);

            entrada.close();
            saida.close();
            conexao.close();
        } catch(IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
