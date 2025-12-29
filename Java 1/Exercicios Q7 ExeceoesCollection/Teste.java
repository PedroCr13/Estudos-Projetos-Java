package classes;

//Pedro Cristovao Lopes Fogaca
public class Teste {
    
    private static Leitura l = new Leitura();
    private static BDVeiculos bd = new BDVeiculos();
    
    /*metodo para receber numero e fazer tratamento da exceção 
    NumeberFormatException enquanto usuário não fornece valor númerico*/
    public static int recebeNumero(String label){
        boolean valida = false;
        int numero = 0;
        while (!valida){
            try{
                numero = Integer.parseInt(l.entDados(label));
                valida = true;
            } catch (NumberFormatException nfe){
                System.out.print("[Erro] Valor é númerico! ");
            }
        }
        return numero;
    }
    
    public static void cadastrarVeiculoDePasseio(){
        boolean voltaAoMenu = false; 
        
        System.out.println("\n *Cadastrar Veiculo de Passeio* \n");
        
        Passeio p = new Passeio();
        p.setPlaca(l.entDados("Qual a Placa?")); 
        p.setMarca(l.entDados("Qual a Marca?"));
        p.setModelo(l.entDados("Qual o Modelo?"));
        p.setCor(l.entDados("Qual a Cor?"));
        p.setQtdRodas(recebeNumero("Quantas rodas?"));

        /*Ao definir a velocidade máxima caso gere execeção VelocException será 
        atribuido 100 kn/h para a velocidadeMáxima.*/
        try{
            p.setVelocMax(recebeNumero("Qual a velocidade máxima?"));
        }
        catch(VelocException velMaxE){
            velMaxE.concertaVelocMax(p, 100);
        }

        p.setQtdePassageiros(recebeNumero("Quantos passageiros?"));
        p.getMotor().setPotencia(recebeNumero("Qual a potência do motor?"));
        p.getMotor().setQtdPist(recebeNumero("Quantos Pistoes do motor?"));

        /*Ao incluir o veiculo caso gere exceção VeicExistException   
        o bloco try seta true p/ variavel voltaAoMenu para não perguntar ao 
        usuário se dejesa cadastrar outro veículo, voltando diretamente para o 
        menu inicial*/
        try{
           bd.cadPasseio(p);
        }    
        catch(VeicExistException veiExE){
            voltaAoMenu = true;
            l.entDados("\n<Tecle [enter] para voltar ao Menu>");
        }
  
        if (!voltaAoMenu){
            String resp = l.entDados("\nDeseja Cadastrar outro veiculo? s ou n");
            if (resp.equalsIgnoreCase("s")){
                cadastrarVeiculoDePasseio();
            }    
        }
    }
    
    public static void excluirVeiculoPasseioPorPlaca(){
        System.out.println("\n *Excluir Veiculo de Passeio por Placa*");
        
        Passeio p = new Passeio();
        p.setPlaca(l.entDados("\n Digite a placa do veiculo:"));
        
        if (bd.pesquisaPasseio(p) == null){
            System.out.println("\n Nao há veiculo com placa: " + p.getPlaca());
        } else {
            if (bd.excPasseioPlaca(p)!= null){
                System.out.println("\nVeiculo passeio excluído!");
            } else {
                System.out.println("\nVeiculo passeio não foi excluído!");
            } 
        }
        l.entDados("\n<Tecle [enter] para voltar ao Menu>");
    }
    
    public static void imprimirTodoVeiculosDePasseio(){
        System.out.println("\n *Imprimir todos os Veículos de Passeio*");
        bd.imprimirTodosVeiculosPasseio();
        l.entDados("\n<Tecle [enter] para voltar ao Menu>");
    }
    
    public static void imprimirVeiculoPasseioPelaPlaca(){     
        Passeio p = new Passeio();
        System.out.println("\n *Imprimir Veículos de Passeio Por Placa* \n");
        p.setPlaca(l.entDados("Digite a placa do Veículo de Passeio"));
        bd.imprimeVeiculoPasseioPorPlaca(p); 
        l.entDados("\n<Tecle [enter] para voltar ao Menu>");
    }
    
    public static void cadastrarVeiculoDeCarga(){
        boolean voltaAoMenu = false; 

        System.out.println("\n *Cadastrar Veiculo de Carga* \n");
        
        Carga c = new Carga();
        c.setPlaca(l.entDados("Qual a Placa?")); 
        c.setMarca(l.entDados("Qual a Marca?"));
        c.setModelo(l.entDados("Qual o Modelo?"));
        c.setCor(l.entDados("Qual a Cor?"));
        c.setQtdRodas(recebeNumero("Quantas rodas?"));
        
        /*Ao definir a velocidade máxima de veiculo de Carga caso gere execeção 
        VelocException é atribuido 90 km/h para a velocidadeMáxima.*/
        try{
            c.setVelocMax(recebeNumero("Qual a velocidade máxima?"));
        }
        catch(VelocException velMaxE){
            velMaxE.concertaVelocMax(c, 90);
        }
        
        c.setTara(recebeNumero("Qual a Tara?"));
        c.setCargaMax(recebeNumero("Qual a Carga Máxima?"));        
        c.getMotor().setPotencia(recebeNumero("Qual a potência do motor?"));
        c.getMotor().setQtdPist(recebeNumero("Quantos Pistoes do motor?"));

        try{
            bd.cadCarga(c);
        }    
        catch(VeicExistException veiExE){
            voltaAoMenu = true;
            l.entDados("\n<Tecle [enter] para voltar ao Menu>");
        }
  
        if (!voltaAoMenu){
            String resp = l.entDados("\nCadastrar outro veiculo de Carga? s ou n");
            if (resp.equalsIgnoreCase("s")){
                cadastrarVeiculoDeCarga();
            }    
        }
    }
    
    public static void excluirVeiculoCargaPorPlaca(){
        System.out.println("\n *Excluir Veiculo de Carga por Placa* ");
       
        Carga c = new Carga();
        c.setPlaca(l.entDados("\n Digite a placa do veiculo:"));
        
        if (bd.pesquisaCarga(c) == null){
            System.out.println("\n Nao há veiculo com placa: " + c.getPlaca());
        } else {
            if (bd.excCargaPlaca(c)!= null){
                System.out.println("\nVeiculo de Carga excluído!");
            } else {
                System.out.println("\nVeiculo de Carga não foi excluído!");
            } 
        }
        l.entDados("\n<Tecle [enter] para voltar ao Menu>");
    }    
    
    public static void imprimirTodoVeiculosCarga(){
        System.out.println("\n *Imprimir todos os Veículos de Carga* ");
        bd.imprimirTodosVeiculosCarga();
        l.entDados("\n<Digite uma tecla para voltar ao Menu>");
    }
    
    public static void imprimirVeiculoCargaPelaPlaca(){     
        Carga c = new Carga();
        System.out.println("\n *Imprimir Veículos de Passeio Por Placa* \n");
        c.setPlaca(l.entDados("Digite a placa do veiculo de carga"));
        bd.imprimeVeiculCargaPorPlaca(c);
        l.entDados("\n<Tecle [enter] para voltar ao Menu>");
    }
    
    public static void main(String args[]){
        
        boolean continua = true;
        int opcao = 0;
        
        while (continua){
            System.out.println("\n  Sistema de Gestão de Veículos - Menu Inicial \n");
            System.out.println("1) Cadastrar Veículo de Passeio");
            System.out.println("2) Cadastrar Veiculo de Carga");
            System.out.println("3) Imprimir Todos os Veículos de Passeio");
            System.out.println("4) Imprimir Todos os Veículos de Carga");
            System.out.println("5) Imprimir Veículo de Passeio por Placa");
            System.out.println("6) Imprimir Veículo de Carga por Placa");
            System.out.println("7) Excluir Veiculo de Passeio por Placa");
            System.out.println("8) Excluir Veiculo de Carga por Placa");
            System.out.println("9) Sair do Sistema");
            
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
                        excluirVeiculoPasseioPorPlaca();
                        break;
                       
                case 8: 
                        excluirVeiculoCargaPorPlaca();
                        break;
                    
                case 9: 
                        continua = false;
                        break;
                
                default:
                        System.out.println("O valor deve estar entre 1 e 7");
                        break;   
            }
        } 
    }
}
