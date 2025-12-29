//Pedro Cristovao Lopes Fogaca
package classes;

public class Teste {
    
    public static boolean pergunta(String texto){
        Leitura leitura = new Leitura(); 
        String resp = leitura.entDados(texto + " s p/ sim n p/ não");
        
        if (resp.equals("s")){
            return true;
        } else {
            return false;
        }
    }

    public static void exibeMenu(){
        System.out.println("\nSistema de Gestão de Veículos Menu Inicial");
        System.out.println("1 - Cadastrar Veículo de Passeio");
        System.out.println("2 - Cadastrar Veículo de Carga");
        System.out.println("3 - Imprimir todos os Veículos de Passeio");
        System.out.println("4 - Imprimir todos os Veículos de Carga");
        System.out.println("5 - Imprimir Veículos de Passeio pela placa");
        System.out.println("6 - Imprimir Veículos de Carga pela placa");
        System.out.println("7 - Sair do Sistema");    
    }
    
    public static boolean veiculoCadastrado(Veiculo[] veiculo, String placa){
        for(int i = 0; i < veiculo.length; i++){
            if (veiculo[i]!= null){
                if (veiculo[i].getPlaca().equals(placa)){
                    return true;
                }
            } 
        }
        return false;
    }
    
    public static int posicaoLivre(Veiculo[] veiculo){ 
        for(int i = 0; i < veiculo.length; i++){
           if (veiculo[i] == null){
               return i;
           } 
        }
        return -1;
    }
    
    public static void cadastrarVeiculoPasseio(Passeio[] veiculo){  
        Leitura leitura = new Leitura();
        int pos = posicaoLivre(veiculo);
        
        System.out.print("\n Cadastrar Veiculo de Passeio\n");
        
        String placa = leitura.entDados("Qual a placa do veiculo?");
        
        if (pos >-1){
            if (!veiculoCadastrado(veiculo, placa)){
                veiculo[pos] = new Passeio();
                veiculo[pos].setPlaca(placa);
                veiculo[pos].setMarca(leitura.entDados("Qual a marca do veiculo?"));
                veiculo[pos].setModelo(leitura.entDados("Qual o Modelo do veiculo?"));
                veiculo[pos].setCor(leitura.entDados("Qual a cor?"));
                veiculo[pos].setQtdePassageiros(Integer.parseInt(leitura.entDados("Quantos passageiros?")));
                veiculo[pos].setQtdRodas(Integer.parseInt(leitura.entDados("Qual qtd de rodas?")));
                veiculo[pos].setVelocMax(Integer.parseInt(leitura.entDados("Qual veloc. maxima?")));
                veiculo[pos].getMotor().setQtdPist(Integer.parseInt(leitura.entDados("Quantos pistões?")));
                veiculo[pos].getMotor().setPotencia(Integer.parseInt(leitura.entDados("Quaal potência?")));
                
                if (pergunta("Deseja cadastrar outro veiculo?")){
                    cadastrarVeiculoPasseio(veiculo);
                }
                
            } else {
                System.out.println("\nVeiculo já cadastrado!");
            }
        } else {
            System.out.println("\nNão há mais espaço para cadastrar veiculos!");
        } 
    }
    
    public static void cadastrarVeiculoCarga(Carga[] veiculo){  
        Leitura leitura = new Leitura();
        int pos = posicaoLivre(veiculo);
        
        System.out.print("\n Cadastrar Veiculo de Carga\n");
        
        String placa = leitura.entDados("Qual a placa do veiculo?");
        
        if (pos >-1){
            if (!veiculoCadastrado(veiculo, placa)){
                veiculo[pos] = new Carga();
                veiculo[pos].setPlaca(placa);
                veiculo[pos].setMarca(leitura.entDados("Qual a marca do veiculo?"));
                veiculo[pos].setModelo(leitura.entDados("Qual o Modelo do veiculo?"));
                veiculo[pos].setCor(leitura.entDados("Qual a cor?"));
                veiculo[pos].setQtdRodas(Integer.parseInt(leitura.entDados("Qual qtd de rodas?")));
                veiculo[pos].setVelocMax(Integer.parseInt(leitura.entDados("Qual veloc. maxima?")));
                veiculo[pos].setCargaMax(Integer.parseInt(leitura.entDados("Qual carga máxima?")));
                veiculo[pos].setTara(Integer.parseInt(leitura.entDados("Qual a tara?")));
                veiculo[pos].getMotor().setQtdPist(Integer.parseInt(leitura.entDados("Quantos pistões?")));
                veiculo[pos].getMotor().setPotencia(Integer.parseInt(leitura.entDados("Quaal potência?")));
                
                if (pergunta("Deseja cadastrar outro veiculo?")){
                    cadastrarVeiculoCarga(veiculo);
                }
                
            } else {
                System.out.println("\nVeiculo já cadastrado!");
            }
        } else {
            System.out.println("\nNão há mais espaço para cadastrar veiculos!");
        } 
    }
    
    public static void mostraVeiculoPasseioNaPosicao(Passeio[] veiculo, int pos){
        System.out.print("\n   ******* Veiculo nº " + (pos + 1) +" ********");
        System.out.println("\nPlaca.............: " + veiculo[pos].getPlaca());
        System.out.println("Marca...............: " + veiculo[pos].getMarca());
        System.out.println("Modelo..............: " + veiculo[pos].getModelo());
        System.out.println("Cor.................: " + veiculo[pos].getCor());
        System.out.println("Qtd de Rodas........: " + veiculo[pos].getQtdRodas());
        System.out.println("Velocidade Máxima...: " + veiculo[pos].getVelocMax()+ " kh/h"); 
        System.out.println("Qtd Pistões Motor...: " + veiculo[pos].getMotor().getQtdPist());
        System.out.println("Potência do Motor...: " + veiculo[pos].getMotor().getPotencia());
        System.out.println("Qtd. de Passageiiros: " + veiculo[pos].getQtdePassageiros());
        System.out.println("Soma das letras.....: " + veiculo[pos].calcular());
        System.out.println("Converte Velocidade.: " + veiculo[pos].calcVel(veiculo[pos].getVelocMax())+" m/h"); 
    }
    
    public static void mostraVeiculoCargaNaPosicao(Carga[] veiculo, int pos){
        System.out.print("\n   ******* Veiculo nº " + (pos + 1) +" ********");
        System.out.println("\nPlaca.............: " + veiculo[pos].getPlaca());
        System.out.println("Marca...............: " + veiculo[pos].getMarca());
        System.out.println("Modelo..............: " + veiculo[pos].getModelo());
        System.out.println("Cor.................: " + veiculo[pos].getCor());
        System.out.println("Qtd de Rodas........: " + veiculo[pos].getQtdRodas());
        System.out.println("Velocidade Máxima...: " + veiculo[pos].getVelocMax()+ " kh/h");
        System.out.println("Qtd Pistões Motor...: " + veiculo[pos].getMotor().getQtdPist());
        System.out.println("Potência do Motor...: " + veiculo[pos].getMotor().getPotencia());
        System.out.println("Tara................: " + veiculo[pos].getTara());
        System.out.println("Carga Máxima........: " + veiculo[pos].getCargaMax());
        System.out.println("Soma numeros........: " + veiculo[pos].calcular());
        System.out.println("Converte Velocidade.: " + veiculo[pos].calcVel(veiculo[pos].getVelocMax())+" cm/h");
    }
    
    public static void imprimirTodosVeiculosPasseio(Passeio[] veiculo){ 
        System.out.print("\n Imprimir todos Veículos de Passeio \n");
        
        if (posicaoLivre(veiculo) == 0){
            System.out.println("\nNão há veiculos cadastrados ainda!");
        } else {
            for (int i = 0; i < veiculo.length; i++) {
                if (veiculo[i] != null){
                    mostraVeiculoPasseioNaPosicao(veiculo, i);
                }
            } 
        }
    }
    
    public static void imprimirTodosVeiculosCarga(Carga[] veiculo){  
        System.out.print("\n Imprimir todos Veículos de Carga \n");
        
        if (posicaoLivre(veiculo) == 0){
            System.out.println("\nNão há veiculos cadastrados ainda!");
        } else {
            for (int i = 0; i < veiculo.length; i++) {
                if (veiculo[i] != null){
                    mostraVeiculoCargaNaPosicao(veiculo, i);
                }
            } 
        }
    }
    
    public static void imprimirVeiculoPasseioPorPlaca(Passeio[] veiculo){
        Leitura leitura = new Leitura();         
        String placa = leitura.entDados("Por favor, Digite a placa!");
        
        boolean achou = false;
        
        System.out.print("\n Veiculos de Passeio por placa: \n");
        
        for (int i = 0; i < veiculo.length; i++) {
            if (veiculo[i] != null){
                if (veiculo[i].getPlaca().equals(placa)){;
                    mostraVeiculoPasseioNaPosicao(veiculo, i);
                    achou = true;
                    break;
                }
             }
        }
        
        if (!achou){
             System.out.print("\nPlaca "+placa+" não encontrada!\n");
        }
    }
    
    public static void imprimirVeiculoCargaPorPlaca(Carga[] veiculo){
        Leitura leitura = new Leitura();         
        String placa = leitura.entDados("Por favor, Digite a placa!");
        
        boolean achou = false;
        
        System.out.print("\n Veiculos de Carga por placa: \n");
        
        for (int i = 0; i < veiculo.length; i++) {
            if (veiculo[i] != null){
                if (veiculo[i].getPlaca().equals(placa)){;
                    mostraVeiculoCargaNaPosicao(veiculo, i);
                    achou = true;
                    break;
                }
             }
        }
        
        if (!achou){
             System.out.print("\nPlaca "+placa+" não encontrada!\n");
        }
    }
    
    public static void main(String arg[]){
        Leitura leitura = new Leitura();
        Passeio[] passeio = new Passeio[5];
        Carga[] carga = new Carga[5];
          
        int opcao = 0;
        
        do{
          exibeMenu();
          opcao = Integer.parseInt(leitura.entDados("\nQual opcao?"));
          
            switch(opcao){
                case 1:
                    cadastrarVeiculoPasseio(passeio);
                    break;
                case 2:
                    cadastrarVeiculoCarga(carga);
                    break;

                case 3:
                    imprimirTodosVeiculosPasseio(passeio);
                    break;

                case 4:
                    imprimirTodosVeiculosCarga(carga);
                    break;

                case 5:
                    imprimirVeiculoPasseioPorPlaca(passeio);
                    break;

                case 6: 
                    imprimirVeiculoCargaPorPlaca(carga);
                    break; 
            }
     
        } while(opcao != 7);
    } 
}
