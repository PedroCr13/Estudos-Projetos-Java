package edu.utfpr.exemplo_servidor_objetos;

import java.net.*;
import java.io.*;

public class ServidorObjeto {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket servidor = new ServerSocket(54321);
        Socket conexao = servidor.accept();

        //representa os dados, permite receber dados
        ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());

        Pessoa p = (Pessoa) entrada.readObject();

        System.out.println("Nome: " + p.getNome() + "\nIdade: " + p.getIdade());

        entrada.close();
        conexao.close();
    }
}
