/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caelum;

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class LeituraComScanner {
    
    public static void main(String[] args) throws IOException{   
        
        Scanner s = new Scanner(System.in);
        PrintStream ps = new PrintStream("D:\\Arquivo1.txt");
        while (s.hasNextLine()){
            ps.println(s.nextLine());
         }
        
    }
    
}
