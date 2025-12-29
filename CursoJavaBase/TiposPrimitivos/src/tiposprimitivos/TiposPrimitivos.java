/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiposprimitivos;

import java.util.Scanner;


/**
 *
 * @author notebook
 */
public class TiposPrimitivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner teclado = new Scanner(System.in);
       System.out.println("Digite o nome do aluno:");
       String nome = teclado.nextLine();
       System.out.println("Digite a nota do aliuno:");
       float nota = teclado.nextFloat();      
       System.out.format("A nota de %s é %.2f \n", nome, nota);
    }
    
}
