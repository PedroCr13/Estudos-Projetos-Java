import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Par{

	public static void main(String args[]){
		
		int resp = 1;
		
		do {
			
			int a = entDados("\nDigite um valor: ");
	
			if (a%2 == 0){
				System.out.println("É numero par!");
			}
			else {
				System.out.println("É impar!");
			}	
			
			resp = entDados("\nDigite 1 para testar de novo.");
			
		} while (resp == 1);		
	}
	
	public static Integer entDados(String label){
		
		System.out.println(label);
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