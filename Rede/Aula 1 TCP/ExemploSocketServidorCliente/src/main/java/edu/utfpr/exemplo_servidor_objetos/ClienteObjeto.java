package edu.utfpr.exemplo_servidor_objetos;

import java.net.*;
import java.io.*;

public class ClienteObjeto {

    public static void main(String args[]) throws IOException,
            ClassNotFoundException {

        //estabelece conexão
        Socket conexao = new Socket("127.0.0.1", 54321);

        //representa canal de saída de dados (envio ao servidor)
        ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());

        //instancia objeto serializado
        Pessoa p = new Pessoa("Pedro", 34);

        //envia objeto serializado
        saida.writeObject(p);

        //fecha canais
        saida.close();
        conexao.close();

    }
}
