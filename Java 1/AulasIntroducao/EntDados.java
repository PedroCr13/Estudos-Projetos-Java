import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntDados{
	
	public static void main(String arg[]){
		
		System.out.println("Entre com um valor: ");
		InputStreamReader c = new InputStreamReader(System.in);
		BufferedReader cd = new BufferedReader(c);
		String s = "";
		try{
			s = cd.readLine();
		}
		catch(IOException e){
			System.out.println("Erro de entrada!");
		}	
		int w = Integer.parseInt(s);
		System.out.println("O valor de entrada foi: "+w);
	}
}