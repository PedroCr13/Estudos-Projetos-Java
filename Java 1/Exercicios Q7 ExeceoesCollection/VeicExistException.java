package classes;

//Pedro Cristovao Lopes Fogaca
public class VeicExistException extends Exception{
    
    public VeicExistException(){
        System.out.println("\nJá existe um veículo com está placa");
    }

}
