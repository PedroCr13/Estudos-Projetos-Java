package br.ejb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.ObjectMessage;
import jakarta.jms.TextMessage;
import java.util.List;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", 
            propertyValue = "java/FilaJogo"), 
    @ActivationConfigProperty(propertyName = "destinationType", 
            propertyValue = "jakarta.jms.Queue"), 
    
})
public class EjbConsumidorFila implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        try {
            if (msg instanceof ObjectMessage objMsg) {
                List<String> ranking = (List<String>) objMsg.getObject();
                System.out.println("Novo lider! Ranking atualizado: ");
                System.out.println("Posicao: - Nome: - Pontos:");
                
                for (String classificacao : ranking) {
                    System.out.println(classificacao);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu erro ao receber raking: " + e.getMessage());
        } 
    }
}
