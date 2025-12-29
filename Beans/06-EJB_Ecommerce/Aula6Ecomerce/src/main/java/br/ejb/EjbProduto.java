package br.ejb;

import br.data.crud.CrudProduto;
import br.data.model.Produto;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
@Stateless
@LocalBean
public class EjbProduto {

    // Metodo para retornar a lista de produtos
    // usado Stateless pois pode ser resolvido com uma única chamdada
    public ArrayList<Produto> getAll() {
        return new CrudProduto().getAll();
    }
}
