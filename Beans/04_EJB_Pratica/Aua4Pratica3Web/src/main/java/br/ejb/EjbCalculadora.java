package br.ejb;

import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;

/**
 *
 * @author pedro
 */
@Stateless
@LocalBean
public class EjbCalculadora implements bri.ICalculadora {

    @Override
    public int somar(int a, int b) {
        return a + b; 
    }
}
