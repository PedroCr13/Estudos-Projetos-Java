package classes;

//Pedro Cristovao 
public class VeicExistException extends Exception{
    
    public VeicExistException(){
        System.out.println("\nJá existe um veículo com está placa");
    }

}
