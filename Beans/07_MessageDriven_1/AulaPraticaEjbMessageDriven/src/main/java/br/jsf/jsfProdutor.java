package br.jsf;

import jakarta.annotation.Resource;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.jms.JMSConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;
import jakarta.jms.TextMessage;

/**
 *
 * @author pedro
 */
// produtor que vai enviar para a fila

@Named(value = "jsfProdutor")
@RequestScoped
public class jsfProdutor {

    @Resource(mappedName = "java/Fila")
    private Queue javaFila;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;
    
    // Caso ocorra erro de não instanciar:
    //@Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    //private ConnectionFactory connectionFactory;

    /**
     * Creates a new instance of jsfProdutor
     */
    public jsfProdutor() {
    }

    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    private void sendJMSMessageToFila(String messageData) {
        context.createProducer().send(javaFila, messageData);
    }
  
    public void send() {
        context.createProducer().send(javaFila, mensagem);
    }
    
    /*
    Caso naõ instancie, criar contexto, desconementar linha ConnectionFactory e comentar Send
    public void send() {
        try{
            JMSContext context = connectionFactory.createContext();
            context.createProducer().send(javaFila, "Olá mundo");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    */
}
