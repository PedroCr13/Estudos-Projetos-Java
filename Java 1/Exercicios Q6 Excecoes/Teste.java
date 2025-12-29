package classes;

//Pedro Cristovao 
public class Teste {
    
    private static Leitura l = new Leitura();
    private static BDVeiculos bd = new BDVeiculos();
    
    public static void exibeMenu(){
        System.out.println("\n  Sistema de Gestão de Veículos - Menu Inicial ");
        System.out.println("1) Cadastrar Veículo de Passeio");
        System.out.println("2) Cadastrar Veiculo de Carga");
        System.out.println("3) Imprimir Todos os Veículos de Passeio");
        System.out.println("4) Imprimir Todos os Veículos de Carga");
        System.out.println("5) Imprimir Todos os Veículos de Passeio por Placa");
        System.out.println("6) Imprimir Todos os Veículos de Carga por Placa");
        System.out.println("7) Sair do Sistema");
    }
    
    /*É criado um objeto p que será alimentado neste metodo, ao final o bjeto p
    é passado como parâmetro para a classe BDVeiculos atraveés do metodo 
    bd.cadPasseio() que o incluirá no vetor Veiculos daquela classe.*/
    public static void cadastrarVeiculoDePasseio(){
        boolean voltaAoMenu = false; 
        Passeio p;
        
        System.out.println("\n ***Cadastrar Veiculo de Passeio*** ");
        p = new Passeio();
        p.setPlaca(l.entDados("Qual a Placa?")); 
        p.setMarca(l.entDados("Qual a Marca?"));
        p.setModelo(l.entDados("Qual o Modelo?"));
        p.setCor(l.entDados("Qual a Cor?"));
        p.setQtdRodas(Integer.parseInt(l.entDados("Quantas rodas?")));
        
        /*Ao definir a velocidade máxima caso gere execeção VelocException será 
        atribuido 100 kn/h para a velocidadeMáxima.*/
        try{
            p.setVelocMax(Integer.parseInt(l.entDados("Qual a velocidade máxima?")));
        }
        catch(VelocException velMaxE){
            velMaxE.concertaVelocMax(p, 100);
        }
        
        p.setQtdePassageiros(Integer.parseInt(l.entDados("Quantos passageiros?")));
        p.getMotor().setPotencia(Integer.parseInt(l.entDados("Qual a potência do motor?")));
        p.getMotor().setQtdPist(Integer.parseInt(l.entDados("Quantos Pistoes do motor?")));

        /*Ao incluir o veiculo caso gere exceção VeicExistException   
        o bloco try seta true p/ variavel voltaAoMenu para não perguntar ao 
        usuário se dejesa cadastrar outro veículo, voltando diretamente para o 
        menu inicial*/
        try{
           bd.cadPasseio(p);
        }    
        catch(VeicExistException veiExE){
            voltaAoMenu = true;
            l.entDados("\n<Digite uma tecla para voltar ao Menu>");
        }
  
        if (!voltaAoMenu){
            String resp = l.entDados("\nDeseja Cadastrar outro veiculo? s ou n");
            if (resp.equalsIgnoreCase("s")){
                cadastrarVeiculoDePasseio();
            }    
        }
    }
    
    public static void imprimirTodoVeiculosDePasseio(){
        System.out.println("\n *** Imprimir todos os Veículos de Passeio ***");
        bd.imprimirTodosVeiculosPasseio();
        l.entDados("\n<Digite uma tecla para voltar ao Menu>");
    }
    
    public static void imprimirVeiculoPasseioPelaPlaca(){     
        Passeio p = new Passeio();
        System.out.println("\n *** Imprimir Veículos de Passeio Por Placa ***");
        p.setPlaca(l.entDados("\nDigite a placa do Veículo de Passeio"));
        bd.imprimeVeiculoPasseioPorPlaca(p); 
        l.entDados("\n<Digite uma tecla para voltar ao Menu>");
    }
    
    public static void cadastrarVeiculoDeCarga(){
        boolean voltaAoMenu = false; 
        Carga c;
        
        System.out.println("\n *** Cadastrar Veiculo de Carga *** ");
        c = new Carga();
        c.setPlaca(l.entDados("Qual a Placa?")); 
        c.setMarca(l.entDados("Qual a Marca?"));
        c.setModelo(l.entDados("Qual o Modelo?"));
        c.setCor(l.entDados("Qual a Cor?"));
        c.setQtdRodas(Integer.parseInt(l.entDados("Quantas rodas?")));
        
        /*Ao definir a velocidade máxima de veiculo de Carga caso gere execeção 
        VelocException é atribuido 90 km/h para a velocidadeMáxima.*/
        try{
            c.setVelocMax(Integer.parseInt(l.entDados("Qual a velocidade máxima?")));
        }
        catch(VelocException velMaxE){
            velMaxE.concertaVelocMax(c, 90);
        }
        
        c.setTara(Integer.parseInt(l.entDados("Qual a Tara?")));
        c.setCargaMax(Integer.parseInt(l.entDados("Qual a Carga Máxima?")));        
        c.getMotor().setPotencia(Integer.parseInt(l.entDados("Qual a potência do motor?")));
        c.getMotor().setQtdPist(Integer.parseInt(l.entDados("Quantos Pistoes do motor?")));

        try{
            bd.cadCarga(c);
        }    
        catch(VeicExistException veiExE){
            voltaAoMenu = true;
            l.entDados("\n<Digite uma tecla para voltar ao Menu>");
        }
  
        if (!voltaAoMenu){
            String resp = l.entDados("\nDeseja Cadastrar outro veiculo de Carga? s ou n");
            if (resp.equalsIgnoreCase("s")){
                cadastrarVeiculoDeCarga();
            }    
        }
    }
    
    public static void imprimirTodoVeiculosCarga(){
        System.out.println("\n *** Imprimir todos os Veículos de Carga ***");
        bd.imprimirTodosVeiculosCarga();
        l.entDados("\n<Digite uma tecla para voltar ao Menu>");
    }
    
    public static void imprimirVeiculoCargaPelaPlaca(){     
        Carga c = new Carga();
        System.out.println("\n *** Imprimir Veículos de Passeio Por Placa ***");
        c.setPlaca(l.entDados("\nDigite a placa do veiculo de carga"));
        bd.imprimeVeiculCargaPorPlaca(c);
        l.entDados("\n<Digite uma tecla para voltar ao Menu>");
    }
    
    public static void main(String args[]){
        
        boolean continua = true;
        int opcao = 0;
        
        while (continua){
            exibeMenu();
            try{
                opcao = Integer.parseInt(l.entDados("\nDigite uma opção"));
            }catch(NumberFormatException nfe){
                l.entDados("");
                continue;
            }
            
            switch(opcao){
                case 1:
                   cadastrarVeiculoDePasseio();
                break;
                
                case 2:
                    cadastrarVeiculoDeCarga();
                break;
                
                case 3:
                    imprimirTodoVeiculosDePasseio();
                break;
                
                case 4:
                    imprimirTodoVeiculosCarga();
                break;
                
                case 5:
                    imprimirVeiculoPasseioPelaPlaca();
                break;
                
                case 6:
                    imprimirVeiculoCargaPelaPlaca();
                break;
                    
                case 7:
                    continua = false;
                break;
                
                default:
                    System.out.println("O valor deve estar entre 1 e 7");
                break;   
            }
        } 
    }
}
