import java.io.*;

public class Saida{
	public static void main(String[] args){
		
		String nome = "Pedro Cristovao Lopes Fogaca";
		String endereco = "Rua Madre Gilda, 125, Jurumirim, Piraju-SP";
		
		System.out.println("Nome: " + nome);
		System.out.println("Endereco: " + endereco);
		
		for(int i = 0; i < args.length; i++){
			System.out.println(args[i]);
		}
	}
}