package br.jsf;

import br.ejb.EjbLocalLocal;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

/**
 *
 * @author pedro
 */
@Named(value = "jsfLocal")
@RequestScoped
public class jsfLocal {

    @EJB
    private EjbLocalLocal ejbLocal;

    /**
     * Creates a new instance of jsfLocal
     */
    public jsfLocal() {
            
    }
    
    private int valor;
    private int resultado;
    
    public void dobrar() {
        resultado = ejbLocal.dobrar(valor);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
