import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LerMatrizBi{
	
	public static void main(String args[]){
		int lin = 2, col = 2, valor = 0;
		int matriz[][] = new int[lin][col];
		
		for (int l = 0; l < lin; l++){
			
			for (int c = 0; c < col; c++  ){
				valor = entDados("Digite o valor para ["+l+"],["+c+"]");
				matriz[l][c] = valor;
			}
		}
		
		for (int l = lin -1; l >= 0; l--){
			for(int c = col -1; c >=  0; c--){
				System.out.println("\n Pos["+l+"],["+c+"] => " + matriz[l][c]);
			}
		}
	}
	
	public static Integer entDados(String label){
		
		System.out.println(label);
		InputStreamReader c = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(c);
		String digitado = "";
		int w = 0;
		boolean cont = true;
		
		while(cont){
			try{
				digitado = buf.readLine();
				w = Integer.parseInt(digitado);
				cont = false;
			}catch(IOException ioe){
				System.out.println("Ocorreu erro!");
			}catch(NumberFormatException nfe){
				System.out.println("O numero deve ser inteiro! Digite novamente!");
			}
		}
		return w;
	}
}