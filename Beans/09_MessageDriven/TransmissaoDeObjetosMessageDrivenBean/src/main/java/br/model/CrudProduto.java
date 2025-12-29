package br.model;

import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class CrudProduto {
    
    public CrudProduto() {
    
    }
    
    public ArrayList<Produto> getAll() {
        ArrayList<Produto> lproduto = new ArrayList<>();
        lproduto.add(new Produto(1, "Computador"));
        lproduto.add(new Produto(2, "Mouse"));
        lproduto.add(new Produto(3, "Teclado"));
        lproduto.add(new Produto(4, "Monitor"));
        return lproduto;
    }
}
