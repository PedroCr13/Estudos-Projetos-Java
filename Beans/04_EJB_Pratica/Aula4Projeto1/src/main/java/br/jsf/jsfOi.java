package br.jsf;

import br.ejb.ejbOla;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

/**
 *
 * @author pedro
 */
@Named(value = "jsfOi")
@RequestScoped
public class jsfOi {

    // Injeta EJB (foi criado como Stateless - sem estado na etapa anterior)
    @EJB
    private ejbOla ejb;
    
    public jsfOi() {
        
    }
    
    public String getOla() {
        return ejb.getOla();
    }
    
}
