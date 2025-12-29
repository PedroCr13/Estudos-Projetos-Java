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

// Configurações iniciais
@MessageDriven(activationConfig = {
    // qual estrutura do servidor que o Ejb irá escutar
    // irá procurar no servidor payara a estrutura java/Fila criada anteriormente na opção Resource > JMS do payara admim
    @ActivationConfigProperty(propertyName = "destinationLookup", 
            propertyValue = "java/Fila"), 
    @ActivationConfigProperty(propertyName = "destinationType", 
            propertyValue = "jakarta.jms.Queue"), 
    
})
public class EjbConsumidor implements MessageListener{

    @Override
    public void onMessage(Message msg) {
        System.out.println("Mensagem recebida");
        try {
           // Cast da mensagem passada como parâmetro para texto
           TextMessage tm = (TextMessage) msg;
            System.out.println(tm.getText());
        } catch (Exception e) {
        
        } 
    }   
}
