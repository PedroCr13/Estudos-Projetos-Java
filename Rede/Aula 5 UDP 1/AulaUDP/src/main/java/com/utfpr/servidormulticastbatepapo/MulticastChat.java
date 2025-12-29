package com.utfpr.servidormulticastbatepapo;

import java.io.*;
import java.net.*;

public class MulticastChat extends Thread {

    private static String user = null;
    private static InetAddress endereco;
    private static int porta;

    public MulticastChat() {

    }

    @Override
    public void run() {
        //Thread abre conexão multicast na porta que foram passados por parametro
        try {

            byte[] buffer = new byte[64];
            MulticastSocket socket = new MulticastSocket(porta);

            socket.joinGroup(endereco);

            // Laço infinito executado preparando datagrama para receber mensagens (receive())
            while(true) {
                DatagramPacket receberPacote = new DatagramPacket(buffer, buffer.length);
                socket.receive(receberPacote);

                //Converte o datagrama recebido em String
                String mensagem = new String(receberPacote.getData());

                //se não houver o nome do usuário é exibida a mensagem
                if (!mensagem.contains(user)) {
                    System.out.println("\r                 ");
                    System.out.println("\n" + mensagem + "\n");
                    System.out.println("Digite a mensagem: ");
                }
                //redeclara o vetor de bytes esvaziando seu conteúdo, pronto para receber novo datagrama
                buffer = new byte[64];
            }

        } catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
        }
    }

    public static void main(String args[]) {

        //verifica se um endereço multicast e uma porta são passados como paramentros no console
        if (args.length != 2) {
            System.out.println("Parametros incorretos: java MulticastChat <multicast> <porta>");
            System.exit(1);
        }

        try {
            //atribui os parametros recebidos às variáveis:
            porta = Integer.parseInt(args[1]);
            endereco = InetAddress.getByName(args[0]);

            //Thread que será responsável pelo fluxo de recebimento das mensagens
            Thread t = new MulticastChat();
            t.start();

            //digitaçaõ de dados via console
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            byte[] buffer = new byte[64];

            //nome do usuário
            System.out.println("Digite o seu nome: ");
            user = entrada.readLine();

            //objeto socket para que o processo possa se juntar ao grupo representado pelo endereço
            MulticastSocket socket = new MulticastSocket();
            socket.joinGroup(endereco);

            //Laço infinito: uma mensagem e solicitada e tratada
            while (true) {
                System.out.println("Digite a mensagem: ");
                String mensagem = entrada.readLine();

                if (mensagem.equals("sair")) System.exit(0);

                mensagem = user + " diz: " + mensagem;

                buffer = mensagem.getBytes();

                //datagrama é criado e enviado através do socket contendo a mensagem
                //enviao ao endereço ao qual diversos processos estão conectados
                DatagramPacket envarPacote = new DatagramPacket(buffer, buffer.length, endereco, porta);

                socket.send(envarPacote);
            }

        } catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
        }
    }
}
