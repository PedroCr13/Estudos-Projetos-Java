package classes;

//Pedro Cristovao

import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {
  
    private List<Passeio> BDPas;
    private List<Carga> BDCarg;
    
    public BDVeiculos(){
        BDPas = new ArrayList<Passeio>();
        BDCarg = new ArrayList<Carga>(); 
    }
    
    public Passeio pesquisaPasseio(Passeio p){
        for(int i = 0; i < BDPas.size(); i++){
            if (BDPas.get(i).getPlaca().equalsIgnoreCase(p.getPlaca())){
                return BDPas.get(i);
            }
        }
        return null;
    }  
    
    public Passeio pesquisaPasseioPorIndice(int indice){
        if (indice >= BDPas.size()){
            return null;
        } else
        if (BDPas.get(indice) != null){
            return BDPas.get(indice);
        } else {
            return null;
        }
    }
    
    public boolean cadPasseio(Passeio p) throws VeicExistException{
        if (pesquisaPasseio(p) != null){
            throw new VeicExistException();
        } else {
            return BDPas.add(p); 
        }            
    }
    
    public Passeio excPasseioPlaca(Passeio p){
        for (int i = 0; i < BDPas.size(); i++){
            if (BDPas.get(i).getPlaca().equalsIgnoreCase(p.getPlaca())){
                return BDPas.remove(i);
            }
        }
        return null;
    }

    public Carga pesquisaCarga(Carga c){
        for(int i = 0; i < BDCarg.size(); i++){
            if (BDCarg.get(i).getPlaca().equalsIgnoreCase(c.getPlaca())){
                return BDCarg.get(i);
            }
        }
        return null;
    }  
    
    public Carga pesquisaCargaPorIndice(int indice){
        if (indice >= BDCarg.size()){
            return null;
        } else
        if (BDCarg.get(indice) != null){
            return BDCarg.get(indice);
        } else {
            return null;
        }
    }
    
    public boolean cadCarga(Carga c) throws VeicExistException{
        if (pesquisaCarga(c) != null){
            throw new VeicExistException();
        } else {
            return BDCarg.add(c);
        }          
    }
    
    public Carga excCargaPlaca(Carga c){
        for (int i = 0; i < BDCarg.size(); i++){
            if (BDCarg.get(i).getPlaca().equalsIgnoreCase(c.getPlaca())){
                return BDCarg.remove(i);
            }
        }
        return null;
    }
}

