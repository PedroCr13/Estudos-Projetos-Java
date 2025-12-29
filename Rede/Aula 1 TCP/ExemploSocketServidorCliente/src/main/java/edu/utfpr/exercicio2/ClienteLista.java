package edu.utfpr.exercicio2;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class ClienteLista {

    public static void main(String[] args) {
        //instanciar a lista de pessoas
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Leitura leitura = new Leitura();

        try {
            //estabelecer conexão
            Socket conexao = new Socket("127.0.0.1", 54326);

            //Abrir sub-canais de comunicação
            ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
         //   ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());

            //processamento
            for (int i = 0; i < 2; i++) {
               Pessoa p = new Pessoa();
               p.setNome(leitura.lerDados("Nome: "));
               p.setCpf(leitura.lerDados("Cpf: "));
             //  p.setEndereco(leitura.lerDados("Endereco: ));
             //  p.setEmail(leitura.lerDados("Email: "));
               p.setIdade(Integer.parseInt(leitura.lerDados("Idade: ")));
             //  p.setIdade(Integer.parseInt(leitura.lerDados()));

               pessoas.add(p);
            }

            //enviar cada objeto pessoa ao servidor (não é a lista)
            //saida.writeObject();

            for (Pessoa p : pessoas){
                saida.writeObject(p);
            }

            //fechar sub-canais de comunicação
           // entrada.close();
            saida.close();
            conexao.close();
        }
        catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
        }
    }
}
