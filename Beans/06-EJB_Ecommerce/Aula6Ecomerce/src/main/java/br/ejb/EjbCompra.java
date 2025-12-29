package br.ejb;

import br.data.model.ItemCompra;
import br.data.model.Produto;
import jakarta.ejb.Stateful;
import jakarta.ejb.LocalBean;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
@Stateful // Mantem sessão (estado)
@LocalBean
public class EjbCompra {

    private ArrayList<ItemCompra> lcompra;
    
    public EjbCompra() {
        // Inicializar a lista de compra
        lcompra = new ArrayList<>();
    }
    
    // Metodos de negócio:
    
    public void add(Produto produto){
        boolean achou = false;
        
        for (ItemCompra itemCompra : lcompra) {
            // Se já esta na lista
            if (itemCompra.getProduto().getCodigo() == produto.getCodigo()) {
                itemCompra.setQuantidade(itemCompra.getQuantidade() + 1);
                achou = true;
                break;
            }
        }
        // Se nao estiver na lista adiciona um novo elemento
        if (!achou) {
            lcompra.add(new ItemCompra(produto, 1));
        }
    }
    
    // Meotod para retornar lista de compra
    public ArrayList<ItemCompra> getAll() {
        return lcompra;
    }
    
    // Metodo para limpar lista, declarar na jsf (interface poder invocá-lo)
    public void limparLista() {
        lcompra = new ArrayList<>();
    }
}
