package br.data.crud;

import br.data.model.Produto;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */

// Simular persistêcia
public class CrudProduto {
    public ArrayList<Produto> getAll() {
        ArrayList<Produto> lprod = new ArrayList<>();
        lprod.add(new Produto(1, "Computador"));
        lprod.add(new Produto(2, "Monitor"));
        lprod.add(new Produto(3, "Mouse"));
        lprod.add(new Produto(4, "Teclado"));
        lprod.add(new Produto(5, "web Cam"));
   
        // Ejb irá chamar e consultar e retornar lista
        // consegue resolver em uma única chamada, vai usar Ejb tipo Stateless
        
        return lprod;
    }
}
