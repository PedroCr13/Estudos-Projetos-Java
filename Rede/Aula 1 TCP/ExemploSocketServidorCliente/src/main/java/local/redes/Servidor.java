package local.redes;

import edu.utfpr.tcp_atividade_1.Validador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//@author Pedro Cristovão lopes fogaça

public class Servidor {

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(50000);
            Socket conexao = servidor.accept();

            DataInputStream entrada = new DataInputStream(conexao.getInputStream());
            DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

            String cpf = entrada.readUTF();

            Validador v = new Validador(cpf);

            String resultado = "";

            if (v.cpfValido()) {
                resultado = "Este cpf é válido.";
            } else {
                resultado = "Este cpf é inválido";
            }

            saida.writeUTF(resultado);

            entrada.close();
            saida.close();
            conexao.close();
        } catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
        }
    }
}
