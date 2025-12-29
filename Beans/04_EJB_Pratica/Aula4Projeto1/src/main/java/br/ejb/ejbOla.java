package br.ejb;

import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;

/**
 *
 * @author pedro
 */
@Stateless
@LocalBean
public class ejbOla {

    public String getOla(){
        return "Olá meu primeiro projeto EJB com JSF";
    }
}
