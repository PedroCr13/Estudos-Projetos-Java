/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import jakarta.annotation.Resource;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;
import jakarta.jms.Topic;

/**
 *
 * @author pedro
 */
@Named(value = "jsfProdT")
@RequestScoped
public class jsfProdT {
    
    private String mensagem;
    private int quantidade = 1;
    
    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "java/Topico") // conforme nome no servidor.
    private Topic topico; // instancia como topico

    /**
     * Creates a new instance of jsfProdT
     */
    public jsfProdT() {
    }
    
    // A index.xhtml irá invocar este metodo
    public void send() {
        try {
            JMSContext context = connectionFactory.createContext();
            
            // Enviar mensagens quantas vezes estiver definido na variavel qtd
            for (int i = 0; i < quantidade; i++) {
                context.createProducer().send(topico, mensagem + " ["+i+"]");
            }
            
        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
        }
    }
   
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    } 
}
