package br.ejb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

/**
 *
 * @author pedro
 */

// Servidor 
// EJB que será o Consumidor de Tópico (topic criado no Payara Server)

// Configurações iniciais
@MessageDriven(activationConfig = {
    // qual estrutura do servidor que o Ejb irá escutar
    // irá procurar no servidor payara a estrutura java/Topico criada anteriormente na opção Resource > JMS do payara admim
    @ActivationConfigProperty(propertyName = "destinationLookup", 
            propertyValue = "java/Topico"), // configurado no servidor
    @ActivationConfigProperty(propertyName = "destinationType", 
            propertyValue = "jakarta.jms.Topic"), // alterado de .Queue para .Topic
    
})
public class EjbConsumidorT implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        // Quando receber exibe console do servidor (qual consumidor receber)
        System.out.println("(topico) Mensagem recebida pelo: " + this.getClass().getSimpleName());
        try {
           // Cast da mensagem passada como parâmetro para texto
           TextMessage tm = (TextMessage) msg;
            System.out.println(tm.getText());
        } catch (Exception e) {
            
        } 
    }
    
}
