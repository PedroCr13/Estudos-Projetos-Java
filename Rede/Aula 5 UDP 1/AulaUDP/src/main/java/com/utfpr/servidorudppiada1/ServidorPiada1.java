package com.utfpr.servidorudppiada1;

import java.net.*;
import java.io.*;

/*
*  Exemplo UDP (aqui usa o DatagramSocket e DatagramPacket, diferente do TCP que lá usa ServerSocket e Socker)
 * */

public class ServidorPiada1 {

    private static final String piada = "O que cai de pé e corre deitado? R: A chuva!";

    public static void main(String args[]) throws IOException {

        //Objeto responsavel pelo envio e rebimento de pacotes UDP
        DatagramSocket dgSocket = new DatagramSocket(7777);

        //armazena a mensagem (até 128 caracteres)
        byte[] mensagem = new byte[128];

        //armazena tudo que estiver relacionado a um datagrama
        //parametro construtor: variavel onde armazena mensagem e seu tamanho
        //neste caso o datagrama servirá para recebimento de dados
        DatagramPacket dgPacket = new DatagramPacket(mensagem, mensagem.length);

        //Recebe um datagrama e armazena no dgPacket
        dgSocket.receive(dgPacket);

        //atribui conteudo do datagrama recebido a uma string
        String msg = new String(dgPacket.getData());
        System.out.println("A mensagem recebida e " + msg);

        //O datagrama recebido possui endereço e porta
        InetAddress ia = dgPacket.getAddress();
        int porta = dgPacket.getPort();

        //converte a mensagem de resposta pra bytes (metodo da classe String)
        mensagem = piada.getBytes();

        //utiliza outro construtor para adicionar ao datagrama que será enviado
        //a mensagem, tamanho, endereço e porta
        dgPacket = new DatagramPacket(mensagem, mensagem.length, ia, porta);

        //envia ao cliente
        dgSocket.send(dgPacket);
    }
}
