package br.jsf;

import jakarta.annotation.Resource;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;

/**
 *
 * @author pedro
 */

// Irá produzir a mensagem para enviar para a fila, 
// para que o consumidor possa exibir a informação

@Named(value = "jsfProdQ")
@RequestScoped
public class jsfProdQ {

    private String mensagem;
    private int quantidade = 1;
    
    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "java/Fila")
    private Queue fila;
    
    public jsfProdQ() {
    }
    
    // A index.xhtml irá invocar este metodo
    public void send() {
        try {
            JMSContext context = connectionFactory.createContext();
            
            // Enviar mensagens quantas vezes estiver definido na variavel qtd
            for (int i = 0; i < quantidade; i++) {
                context.createProducer().send(fila, mensagem + " ["+i+"]");
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
