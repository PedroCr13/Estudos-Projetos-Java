package classes;

//Pedro Cristovao 
public class BDVeiculos {
  
    private Passeio[] passeio;
    private Carga[] carga;
    
    public BDVeiculos(){
        passeio = new Passeio[5];
        carga = new Carga[5];
    }
    
    /*
    retorna indice vazio no vetor para alocar um novo objeto Passeio
    ou retorna -1 caso o vetor esteja lotado
    */
    private int posicaoLivrePasseio(){
        for (int i = 0; i < passeio.length; i++){
            if (passeio[i] == null){
                return i;
            }
        }
        return -1;
    } 
    
    /* percorre o vetor passeio em busca de um objeto com a mesma placa */
    private boolean veiculoPasseioExiste(Passeio p){
        for(int i = 0; i < passeio.length; i++){
            if (passeio[i] != null){
                if (passeio[i].getPlaca().equalsIgnoreCase(p.getPlaca())){
                    return true;
                }
            }
        }
        return false;
    }  
    
    /*
    Recebe um objeto passeio passado por parâmetro na classe Teste e caso no 
    vetor já tenha um objeto com a mesma placa gerará a exceção VeicExistException 
    que deverá ser tratada na classe Teste, se não gerar a excecao, é verificcado 
    se o vetor tem posicao livre e nesta posicao alocado o objeto p recebido.
    */
    public Passeio cadPasseio(Passeio p) throws VeicExistException{
        if (veiculoPasseioExiste(p)){
            throw new VeicExistException();
        }else            
        if (posicaoLivrePasseio() >-1){  
            return passeio[posicaoLivrePasseio()] = p;
        } else
        if (posicaoLivrePasseio() == -1){
            System.out.println("\nNão incluido. Vetor está cheio!");
        }  
        return null;
    }
    
    /*Lista os atributos dos objetos do vetor passeio*/
    public void imprimirTodosVeiculosPasseio(){
        boolean achou = false;
        
        for (int i = 0; i < passeio.length; i++){
            if (passeio[i] != null){
                mostraVeiculoPasseioNaPosicao(i);
                achou = true;
            }
        }
        
        if (!achou){
            System.out.println("\nNão há veiculos de Passeio cadastrados!");
        }
    }
     
    /*Recebe um objeto p e percorre o vetor em busca de um objeto com mesma placa*/
    public void imprimeVeiculoPasseioPorPlaca(Passeio p){
        boolean achou = false;
        for (int i = 0; i < passeio.length; i++){
            if (passeio[i] != null){
                if (passeio[i].getPlaca().equalsIgnoreCase(p.getPlaca())){
                    mostraVeiculoPasseioNaPosicao(i);
                    achou = true;
                    break;
                }
            }
        }
        if (!achou)
            System.out.println("\nVeiculo de paseio por esta Placa não encontrado!");
    }
   
    /*Exibe os valores gets de um obejto p que compõe o vetor no indice soliciado*/
    private void mostraVeiculoPasseioNaPosicao(int posicao){
        System.out.println("\n =================================================");
        System.out.println("\n Posicão do Vetor...: [" + posicao + "]");
        System.out.println("\n Placa..............: " + passeio[posicao].getPlaca());
        System.out.println("\n Marca..............: " + passeio[posicao].getMarca());
        System.out.println("\n Modelo.............: " + passeio[posicao].getModelo());
        System.out.println("\n Cor................: " + passeio[posicao].getCor());
        System.out.println("\n Qtd de Rodas.......: " + passeio[posicao].getQtdRodas());
        System.out.println("\n Velocidade Máxima..: " + passeio[posicao].getVelocMax());
        System.out.println("\n Qtd de Passageiros.: " + passeio[posicao].getQtdePassageiros());
        System.out.println("\n Qtd Pistoes Motor..: " + passeio[posicao].getMotor().getQtdPist());
        System.out.println("\n Potencia do Motor..: " + passeio[posicao].getMotor().getQtdPist());
        System.out.println("\n Velocidade máxima..: " + passeio[posicao].calcVel() + " m/h");
        System.out.println("\n Soma Das letras....: " + passeio[posicao].calcular());
    }
    
     private int posicaoLivreCarga(){
        for (int i = 0; i < passeio.length; i++){
            if (carga[i] == null){
                return i;
            }
        }
        return -1;
    } 
     
    private boolean veiculoCargaExiste(Carga c){
        for(int i = 0; i < carga.length; i++){
            if (carga[i] != null){
                if (carga[i].getPlaca().equalsIgnoreCase(c.getPlaca())){
                    return true;
                }
            }
        }
        return false;
    }  
    
    public Carga cadCarga(Carga c) throws VeicExistException{
        int posicao = posicaoLivreCarga();
       
        if (veiculoCargaExiste(c)){
            throw new VeicExistException();
        } else            
        if (posicao >-1){  
            return carga[posicao] = c;
        } else
        if (posicaoLivrePasseio() == -1){
            System.out.println("\nNão incluido. Vetor está cheio!");
        } 
        return null;
    }
    
    public void imprimirTodosVeiculosCarga(){
        boolean achou = false;
            
        for (int i = 0; i < carga.length; i++){
            if (carga[i] != null){
                mostraVeiculoCargaNaPosicao(i);
                achou = true;
            }
        }
        
        if (!achou){
            System.out.println("\nNão há veiculos de Carga cadastrados!");
        }
    
    }
    
    public void imprimeVeiculCargaPorPlaca(Carga c){ 
        boolean achou = false;
        for (int i = 0; i < carga.length; i++){
            if (carga[i] != null){
                if (carga[i].getPlaca().equalsIgnoreCase(c.getPlaca())){
                        mostraVeiculoCargaNaPosicao(i);
                        achou = true;
                        break;
                }
            }
        } 
        if (!achou)
            System.out.println("\nPlaca não encontrada!");
    }
      
    private void mostraVeiculoCargaNaPosicao(int posicao){
        System.out.println("\n =================================================");
        System.out.println("\n Posicão do Vetor...: [" + posicao + "]");
        System.out.println("\n Placa..............: " + carga[posicao].getPlaca());
        System.out.println("\n Marca..............: " + carga[posicao].getMarca());
        System.out.println("\n Modelo.............: " + carga[posicao].getModelo());
        System.out.println("\n Cor................: " + carga[posicao].getCor());
        System.out.println("\n Qtd de Rodas.......: " + carga[posicao].getQtdRodas());
        System.out.println("\n Velocidade Máxima..: " + carga[posicao].getVelocMax());
        System.out.println("\n Tara...............: " + carga[posicao].getTara() + " kilos");
        System.out.println(" Carga Máxima.........: " + carga[posicao].getCargaMax() +" toneladas");
        System.out.println("\n Qtd Pistoes Motor..: " + carga[posicao].getMotor().getQtdPist());
        System.out.println("\n Potencia do Motor..: " + carga[posicao].getMotor().getQtdPist());
        System.out.println("\n Velocidade máxima..: " + carga[posicao].calcVel() + " m/h");
        System.out.println("\n Soma Dos Números...: " + carga[posicao].calcular());
    }
}

