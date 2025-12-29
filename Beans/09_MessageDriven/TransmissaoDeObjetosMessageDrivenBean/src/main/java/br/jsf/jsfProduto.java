package br.jsf;

import br.model.Produto;
import ejb.EjbProduto;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
@Named(value = "jsfProduto")
@RequestScoped
public class jsfProduto {
    
    @EJB
    private EjbProduto ejbProduto;
    
    /**
     * Creates a new instance of jsfProduto
     */
    public jsfProduto() {
    }
    
    // invocar ejb
    public ArrayList<Produto> getAll() {
        // botão direito, inser code > call enterprise bean
        return ejbProduto.getAll();
    }
    
}
