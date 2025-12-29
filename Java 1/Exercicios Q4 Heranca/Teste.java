/* pedro Cristovao Lopes Fogaça*/
package com.mycompany.listaexercicios;

/**
 *
 * @author Usuario
 */
public class Teste {
    
    public static void main(String args[]){
        
        Passeio carro = new Passeio();  
        carro.setMarca("VW");
        carro.setModelo("Fusca 1977");
        carro.setPlaca("CQG-5156");
        carro.setVelocMax(140);
        carro.setQtdePassageiros(5);
        carro.getMotor().setQtdPist(4);
        carro.getMotor().setPotencia(46);
        
        System.out.println("\n        ** Dados Veiculo **    ");
        System.out.println("Marca;.............: " + carro.getMarca());
        System.out.println("Modelo;............: " + carro.getModelo());
        System.out.println("Placa;.............: " + carro.getPlaca());
        System.out.println("Qtd. Passageiros....: " + carro.getQtdePassageiros());
        System.out.println("Motor: qtd. Pistoes.: " + carro.getMotor().getQtdPist());
        System.out.println("Motor: potência.....: " + carro.getMotor().getPotencia() + " calvalos");
        System.out.println("Velocidade Max.....: " + carro.getVelocMax() + " km/h");
        System.out.println("Velocidade Max.....: " + carro.calcVel(carro.getVelocMax()) + " m/h");
        
        Carga caminhao = new Carga();
        caminhao.setMarca("Volvo");
        caminhao.setModelo("FH16 750");
        caminhao.setPlaca("CGQ-1247");
        caminhao.setVelocMax(89);
        caminhao.setCargaMax(750);
        caminhao.setTara(10000);
        caminhao.getMotor().setQtdPist(6);
        caminhao.getMotor().setPotencia(750);
        
        System.out.println("\n        ** Dados Caminhão**    ");
        System.out.println("Marca;.............: " + caminhao.getMarca());
        System.out.println("Modelo;............: " + caminhao.getModelo());
        System.out.println("Placa;.............: " + caminhao.getPlaca());
        System.out.println("Carga Máxima.......: " + caminhao.getCargaMax() + " toneladas");
        System.out.println("Tara...............: " + caminhao.getTara() + " quilos");
        System.out.println("Motor: qtd. Pistoes.: " + caminhao.getMotor().getQtdPist());
        System.out.println("Motor: potência.....: " + caminhao.getMotor().getPotencia() + " cavalos");
        System.out.println("Velocidade Max.....: " + caminhao.getVelocMax() + " km/h");
        System.out.println("Velocidade Max.....: " + caminhao.calcVel(caminhao.getVelocMax()) + " cm/h"); 
    }  
}
