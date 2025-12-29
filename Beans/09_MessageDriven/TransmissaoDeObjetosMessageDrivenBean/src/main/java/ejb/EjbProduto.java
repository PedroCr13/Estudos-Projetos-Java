package ejb;

import br.model.CrudProduto;
import br.model.Produto;
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
    
    public ArrayList<Produto> getAll() {
        return new CrudProduto().getAll();
    }

}
