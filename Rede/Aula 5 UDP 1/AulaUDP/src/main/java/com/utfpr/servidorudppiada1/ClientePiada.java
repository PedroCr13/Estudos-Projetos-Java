package com.utfpr.servidorudppiada1;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.*;

/*
*  Exemplo UDP
* */

public class ClientePiada {

    public static void main(String args[]) throws IOException {

        DatagramSocket dgSocket = new DatagramSocket(); //não é passada porta

        //vetor de bytes (mesma capacidade do servidor)
        byte[] mensagem = new byte[128];

        // *** envio ***

        String msg = "Quero uma piada.";

        //converte a string em bytes
        mensagem = msg.getBytes();

        //captura o endereço de IP
        InetAddress endereco = InetAddress.getByName("localhost");

        //datagrama que será enviado.
        DatagramPacket dgPacket = new DatagramPacket(mensagem, mensagem.length, endereco, 7777);

        dgSocket.send(dgPacket);

        // *** Recebimento ***

        //aloca vetor para armazenar pacote de até 128 bytes
        //foi redeclarado a fim de limpar o conteúdo anterior atribuído
        //para ser possível receber a mensagem completa
        mensagem = new byte[128];

        //reinstacionado para receber mensagem (construtor com vetor onde será armazenada mensagem e tamanho dela)
        dgPacket = new DatagramPacket(mensagem, mensagem.length);

        dgSocket.receive(dgPacket);

        //Converte datagrama recebido em string
        String piada = new String(dgPacket.getData());

        System.out.println(piada);
    }
}
