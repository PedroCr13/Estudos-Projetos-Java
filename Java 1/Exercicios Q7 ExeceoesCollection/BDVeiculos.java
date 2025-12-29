package classes;

import java.util.ArrayList;
import java.util.List;

//Pedro Cristovao Lopes Fogaca
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
    
    public void cadPasseio(Passeio p) throws VeicExistException{
        if (pesquisaPasseio(p) != null){
            throw new VeicExistException();
        } else {
            BDPas.add(p);
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
    
    public void imprimirTodosVeiculosPasseio(){
        boolean achou = false;
        for (int i = 0; i < BDPas.size(); i++){
            mostraVeiculoPasseioNaPosicao(i);
            achou = true;
        }
        if (!achou){
            System.out.println("\nNão há veiculos de Passeio cadastrados!");
        }
    }
     
    public void imprimeVeiculoPasseioPorPlaca(Passeio p){
        boolean achou = false;
        for (int i = 0; i < BDPas.size(); i++){
            if (BDPas.get(i).getPlaca().equalsIgnoreCase(p.getPlaca())){
                mostraVeiculoPasseioNaPosicao(i);
                achou = true;
                break;
            }
        }
        if (!achou)
            System.out.println("\nVeiculo de paseio por esta Placa não encontrado!");
    }
   
    private void mostraVeiculoPasseioNaPosicao(int posicao){
        System.out.println("\n =================================================");
        System.out.println(" Posicão do ArrayList: [" + posicao + "]");
        System.out.println(" Placa...............: " + BDPas.get(posicao).getPlaca());
        System.out.println(" Marca...............: " + BDPas.get(posicao).getMarca());
        System.out.println(" Modelo..............: " + BDPas.get(posicao).getModelo());
        System.out.println(" Cor.................: " + BDPas.get(posicao).getCor());
        System.out.println(" Qtd de Rodas........: " + BDPas.get(posicao).getQtdRodas());
        System.out.println(" Velocidade Máxima...: " + BDPas.get(posicao).getVelocMax());
        System.out.println(" Qtd de Passageiros..: " + BDPas.get(posicao).getQtdePassageiros());
        System.out.println(" Qtd Pistoes Motor...: " + BDPas.get(posicao).getMotor().getQtdPist());
        System.out.println(" Potencia do Motor...: " + BDPas.get(posicao).getMotor().getPotencia());
        System.out.println(" Velocidade máxima...: " + BDPas.get(posicao).calcVel() + " m/h");
        System.out.println(" Soma Das letras.....: " + BDPas.get(posicao).calcular());
    }  

    public Carga pesquisaCarga(Carga c){
        for(int i = 0; i < BDCarg.size(); i++){
            if (BDCarg.get(i).getPlaca().equalsIgnoreCase(c.getPlaca())){
                return BDCarg.get(i);
            }
        }
        return null;
    }  
    
    public void cadCarga(Carga c) throws VeicExistException{
        if (pesquisaCarga(c) != null){
            throw new VeicExistException();
        } else {
            BDCarg.add(c);
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
    
    public void imprimirTodosVeiculosCarga(){
        boolean achou = false;            
        for (int i = 0; i < BDCarg.size(); i++){
            mostraVeiculoCargaNaPosicao(i);
            achou = true;
        }
        if (!achou){
            System.out.println("\nNão há veiculos de Carga cadastrados!");
        }
    }
    
    public void imprimeVeiculCargaPorPlaca(Carga c){ 
        boolean achou = false;
        for (int i = 0; i < BDPas.size(); i++){
            if (BDPas.get(i).getPlaca().equalsIgnoreCase(c.getPlaca())){
                mostraVeiculoCargaNaPosicao(i);
                achou = true;
                break;
            }
        } 
        if (!achou)
            System.out.println("\nPlaca não encontrada!");
    }
      
    private void mostraVeiculoCargaNaPosicao(int posicao){
        System.out.println("\n =================================================");
        System.out.println(" Posicão do ArrayList: [" + posicao + "]");
        System.out.println(" Placa...............: " + BDCarg.get(posicao).getPlaca());
        System.out.println(" Marca...............: " + BDCarg.get(posicao).getMarca());
        System.out.println(" Modelo..............: " + BDCarg.get(posicao).getModelo());
        System.out.println(" Cor.................: " + BDCarg.get(posicao).getCor());
        System.out.println(" Qtd de Rodas........: " + BDCarg.get(posicao).getQtdRodas());
        System.out.println(" Velocidade Máxima...: " + BDCarg.get(posicao).getVelocMax());
        System.out.println(" Tara................: " + BDCarg.get(posicao).getTara() + " kilos");
        System.out.println(" Carga Máxima........: " + BDCarg.get(posicao).getCargaMax() +" toneladas");
        System.out.println(" Qtd Pistoes Motor...: " + BDCarg.get(posicao).getMotor().getQtdPist());
        System.out.println(" Potencia do Motor...: " + BDCarg.get(posicao).getMotor().getPotencia());
        System.out.println(" Velocidade máxima...: " + BDCarg.get(posicao).calcVel() + " m/h");
        System.out.println(" Soma Dos Números....: " + BDCarg.get(posicao).calcular());
    }
}

