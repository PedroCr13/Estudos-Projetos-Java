package br.ejb;

import jakarta.ejb.Stateless;

/**
 *
 * @author pedro
 */
@Stateless
public class EjbLocal implements EjbLocalLocal {

    // Deve ter assinatura declarada na Interface Local
    public int dobrar(int valor) {
        return valor * 2;
    }
}
