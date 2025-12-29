/* pedro Cristovao Lopes Fogaça*/
package com.mycompany.listaexercicios;

/**
 *
 * @author Usuario
 */
public class Teste {
    
    public static void mostraDadosVeiculos(Veiculo veiculos[]){
       
        for (int i = 0; i < veiculos.length; i++){ 
            if (veiculos[i] != null){
                System.out.println("\n *** Dados do Veiculo nº " + (i + 1) + " ***");
                System.out.println("Marca    : " + veiculos[i].getMarca());
                System.out.println("Modelo   : " + veiculos[i].getModelo());
                System.out.println("Vel. Max : " + veiculos[i].getVelocMax() + " km/h");
                System.out.println("Placa    : " + veiculos[i].getPlaca());
                System.out.println("\n      Dados do Motor");
                System.out.println("Qtd Pistões: " + veiculos[i].getMotor().getQtdPist());
                System.out.println("Potência   : " + veiculos[i].getMotor().getPotencia());
            } 
        }
    }
    
    public static void main(String args[]){
        
        Veiculo carros[] = new Veiculo[10];
        
        carros[0] = new Veiculo();
        carros[0].setMarca( "VW");
        carros[0].setModelo("Fusca");
        carros[0].setPlaca("CQG-5156");
        carros[0].setVelocMax(140);
        carros[0].getMotor().setQtdPist(4);
        carros[0].getMotor().setPotencia(65);
        
        carros[1] = new Veiculo();
        carros[1].setMarca( "VW");
        carros[1].setModelo("Brasilia");
        carros[1].setPlaca("BXD-1234");
        carros[1].setVelocMax(135);
        carros[1].getMotor().setQtdPist(4);
        carros[1].getMotor().setPotencia(60);
        
        carros[2] = new Veiculo();
        carros[2].setMarca( "VW");
        carros[2].setModelo("Variant");
        carros[2].setPlaca("CNN-1230");
        carros[2].setVelocMax(130);
        carros[2].getMotor().setQtdPist(4);
        carros[2].getMotor().setPotencia(63);

        carros[3] = new Veiculo();
        carros[3].setMarca( "VW");
        carros[3].setModelo("Fusca Itamar");
        carros[3].setPlaca("DCH-1455");
        carros[3].setVelocMax(140);
        carros[3].getMotor().setQtdPist(4);
        carros[3].getMotor().setPotencia(65);
        
        carros[4] = new Veiculo();
        carros[4].setMarca( "VW");
        carros[4].setModelo("SP2");
        carros[4].setPlaca("ABC-3211");
        carros[4].setVelocMax(150);
        carros[4].getMotor().setQtdPist(4);
        carros[4].getMotor().setPotencia(75);
        
        carros[5] = new Veiculo();
        carros[5].setMarca( "VW");
        carros[5].setModelo("Zé do Caixão");
        carros[5].setPlaca("CQJ-4674");
        carros[5].setVelocMax(150);
        carros[5].getMotor().setQtdPist(4);
        carros[5].getMotor().setPotencia(60);
        
        carros[6] = new Veiculo();
        carros[6].setMarca( "VW");
        carros[6].setModelo("Kombi");
        carros[6].setPlaca("CFX-9816");
        carros[6].setVelocMax(110);
        carros[6].getMotor().setQtdPist(4);
        carros[6].getMotor().setPotencia(50);
        
        carros[7] = new Veiculo();
        carros[7].setMarca( "VW");
        carros[7].setModelo("karmann Ghia");
        carros[7].setPlaca("CFX-9816");
        carros[7].setVelocMax(125);
        carros[7].getMotor().setQtdPist(4);
        carros[7].getMotor().setPotencia(65);
        
        carros[8] = new Veiculo();
        carros[8].setMarca( "VW");
        carros[8].setModelo("Gol Bx");
        carros[8].setPlaca("CRS-1260");
        carros[8].setVelocMax(160);
        carros[8].getMotor().setQtdPist(4);
        carros[8].getMotor().setPotencia(67);
        
        carros[9] = new Veiculo();
        carros[9].setMarca( "Ford");
        carros[9].setModelo("Corcel");
        carros[9].setPlaca("CIE-1727");
        carros[9].setVelocMax(150);
        carros[9].getMotor().setQtdPist(4);
        carros[9].getMotor().setPotencia(90);
        
        mostraDadosVeiculos(carros); 
    }  
}
