package manipula_texto;

import java.util.ArrayList;
import java.util.List;

public class ListaDeClientes {
    
    private List<Cliente> lista;
    
    public ListaDeClientes(){
        lista = new ArrayList<Cliente>();
    }
    
    public void setLista(List<Cliente> lista){
        this.lista = lista;
    }
    
    public List<Cliente> getLista(){
        return lista;
    }
    
    public int posicaoNaLista(Cliente cliente){
        if (lista.size() >= 0){
            for (int i = 0; i < lista.size(); i++){
                if (lista.get(i).getNome().equalsIgnoreCase(cliente.getNome())){
                    return i;
                }
            }
        }
        return -1;
    }
    
    public boolean inserir(Cliente cliente){
        int posicao = posicaoNaLista(cliente);
        
        //insere se o cliente não estiver na lista
        if (posicao == -1){
            return lista.add(cliente);
        } 
        return false;
    }
    
    public boolean alterar(Cliente cliente, int posicao){
        if (posicao != -1){
            if (lista.set(posicao, cliente)!=null){
                return true;
            }
        }
        return false;
    }
    
    public boolean excluir(Cliente cliente){
        int posicao = posicaoNaLista(cliente);
        
        if (posicao != -1){
            if (lista.remove(posicao) != null){
                return true;
            }
        }
        return false;
    }
    
    public Cliente primeiro(){
        if(lista.size() >= 1){
            return lista.get(0);
        } else {
            return null;
        }
    }
    
    public Cliente proximo(Cliente cliente){
        int posicaoAtual = posicaoNaLista(cliente);
        
        if (posicaoAtual == -1){
            return null;
        } else {
            try{
                if ((posicaoAtual + 1) < lista.size()){
                    return lista.get(posicaoAtual + 1);
                } else {
                    return null;
                }
            } catch (IndexOutOfBoundsException indexOfBounds){
                indexOfBounds.printStackTrace();
            }   
        }
        return null;
    }
    
    public Cliente anterior(Cliente cliente){
        int posicaoAtual = posicaoNaLista(cliente);
        
        if (posicaoAtual == -1){
            return null;
        }
        if (posicaoAtual == 0){
            return lista.get(posicaoAtual);
        }else{
            try{
                if ((posicaoAtual -1) > -1){
                    return lista.get(posicaoAtual - 1);
                }
            } catch (IndexOutOfBoundsException indexOfBounds){
                indexOfBounds.printStackTrace();
            }
        }
        return null;
    }
 
}
