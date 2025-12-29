import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc{
	
	public static void main(String args[]){
		
		int opcao = 0;
		int a, b, c;
		
		do {	
			System.out.println(" *** Calculator ***");
			System.out.println("\n 1 - Somar (a + b)");
			System.out.println("\n 2 - Multiplicar (a * b)");
			System.out.println("\n 3 - Subtrair (a - b)");
			System.out.println("\n 5 - Dividir (a / b)");
			System.out.println("\nEscolha uma opção: ");
			System.out.println("");
			opcao = entDados();
			switch(opcao){
				
				case 1:
					System.out.println("\n *** Somar (a + b) *** ");
					
					a = entDados();
					b = entDados();
					
					c = a + b;
					
					System.out.println("O resultado de " + a + " + " + b + " = " + c );
					
				break;
				
				case 2:
					System.out.println("\n *** Multiplicar (a * b) *** ");
					
					a = entDados();
					b = entDados();
					
					c = a * b;
					
					System.out.println("O resultado de " + a + " * " + b + " = " + c );
				break;
				
				case 3:
					System.out.println("\n *** Subtrair (a - b) *** ");
					
					a = entDados();
					b = entDados();
					
					c = a - b;
					
					System.out.println("O resultado de " + a + " - " + b + " = " + c );
				break;
				
				case 5:
					System.out.println("\n *** Dividir (a * b) *** ");
					
					a = entDados();
					b = entDados();
					
					c = a / b;
					
					System.out.println("O resultado de " + a + " / " + b + " = " + c );
				break;
				
				default:
				break;
				
			}
		} while (opcao <= 5);
	}

	public static Integer entDados(){
		
		System.out.println("Digite o valor:");
		InputStreamReader c = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(c);
		String s = "";
		
		try{	
			s = b.readLine();
		}catch(IOException ioe){
			System.out.println("Erro de entrada!");
		}
		int n = Integer.parseInt(s);
		
		return n;
	}
}