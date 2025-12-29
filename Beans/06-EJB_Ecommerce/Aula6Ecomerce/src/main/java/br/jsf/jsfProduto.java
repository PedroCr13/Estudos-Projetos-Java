package br.jsf;

import br.data.model.Produto;
import br.ejb.EjbProduto;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */

// Esta classe fará conexão do EJB com a interface gráfica (xhtml)
// Injetar Ejb
// @Request uma chamada.

@Named(value = "jsfProduto")
@RequestScoped
public class jsfProduto {
   
    /**
     * Creates a new instance of jsfProduto
     */
    public jsfProduto() {
    }
    
    @EJB
    private EjbProduto ejbProduto;
    
    public ArrayList<Produto> getAll(){
        return ejbProduto.getAll();
    }
    
}
