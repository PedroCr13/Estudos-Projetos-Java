/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import bri.ICalculadora;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

/**
 *
 * @author pedro
 */
@Named(value = "jsfCalculadora")
@RequestScoped
public class jsfCalculadora {

    @jakarta.ejb.EJB
    private ICalculadora ejbCalculadora;

    /**
     * Creates a new instance of jsfCalculadora
     */
    public jsfCalculadora() {
    }
    
    public void somar() {
        resultado = ejbCalculadora.somar(valora, valorb);
    }
    
    private int valora;
    
    private int valorb;
    
    private int resultado;

    public int getValora() {
        return valora;
    }

    public void setValora(int valora) {
        this.valora = valora;
    }

    public int getValorb() {
        return valorb;
    }

    public void setValorb(int valorb) {
        this.valorb = valorb;
    }

    public int getResultado() {
        return resultado;
    }

}
