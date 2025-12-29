package br.jsf;

import br.model.Produto;
import ejb.EjbProduto;
import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSException;
import jakarta.jms.ObjectMessage;
import jakarta.jms.Session;
import jakarta.jms.Topic;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
@Named(value = "jsfProdutor")
@RequestScoped
public class jsfProdutor {
    
    @Resource(lookup = "java/Topico")
    private Topic topico;
  
    // Busca no servidor pela estrutura topico
    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    @EJB
    private EjbProduto ejbProduto;
    /**
     * Creates a new instance of jsfProdutor
     */
    public jsfProdutor() {
    }
    
    // criar um array list produto, conecta no JMS 
    // cria sessão de conexão
    // instancia objeto message
    
    public void send() {    
        ArrayList<Produto> lprod = ejbProduto.getAll();
        try (JMSContext context = connectionFactory.createContext()){
            // Envia para o topico o objeto
            context.createProducer().send(topico, lprod);     
        } catch (Exception ex) {
           System.out.println("Erro:");
           System.out.println(ex.getMessage());
        }
    }    
}
