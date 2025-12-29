package ejb;

import br.model.Produto;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.ObjectMessage;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", 
            propertyValue = "java/Topico"), 
    @ActivationConfigProperty(propertyName = "destinationType", 
            propertyValue = "jakarta.jms.Topic"), 
    
})
public class EjbConsumidorProd implements MessageListener {

    // onMessage é acionado toda vez que a estrutura topico libera um recurso
    @Override
    public void onMessage(Message msg) {
        System.out.println("(Topico) Mensagem recebida pelo: " + this.getClass().getSimpleName());
        
        try {
            // ObjetcMessage: mensgem que o conteúdo será um objeto
            ObjectMessage tm = (ObjectMessage) msg;
            // System.out.println(tm.getClass().getSimpleName()); exibe nome da classe
            System.out.println("Fazendo cast");
            ArrayList<Produto> lprod = new ArrayList();
            
             // obter o coteúdo da mesagem com getObject()
            lprod = (ArrayList<Produto>) tm.getObject();
            
            for (Produto produto : lprod) {
                System.out.println("Peoduto: " + produto.getCodigo() +": "+ 
                                                 produto.getDescricao());
            }
            
        } catch (Exception e) {
            System.out.println("ERRO");
            System.out.println(e.getMessage()); 
        }
    }
}
