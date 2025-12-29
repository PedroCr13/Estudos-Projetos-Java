package edu.utfpr.exercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {

    public String lerDados(String label) {

        String mensagem = "";

        System.out.println(label);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            mensagem = br.readLine();
        } catch (IOException ioe) {
            System.out.println("Erro na leitura: " + ioe.getMessage());
        }
        return mensagem;
    }
}
