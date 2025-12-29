package br.jsf;

import br.data.model.ItemCompra;
import br.data.model.Produto;
import br.ejb.EjbCompra;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
@Named(value = "jsfCompra")
@SessionScoped // Manter sessão do usuario
public class jsfCompra implements Serializable {

    @EJB
    private EjbCompra ejbCompra;
    /**
     * Creates a new instance of jsfCompra
     */
    public jsfCompra() {
    }
    
    public void add(Produto produto) {
        // Não expoe regra de negocio, expoe o Ejb:
        ejbCompra.add(produto);
    }
    
    public ArrayList<ItemCompra> getAll() {
        return ejbCompra.getAll();
    }
    
    public void limparLista() {
        ejbCompra.limparLista();
    }
}
