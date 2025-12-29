import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LerMatriz {
	
	public static void main(String args[]){
	
		int tamanho = 5, valor = 0;;
		int vetor[] = new int[tamanho];
		
		for (int i = 0; i < vetor.length; i++){
			valor = Integer.parseInt(entDados("Digite o valor!"));
			vetor[i] = valor;
		}
		
		for (int i = vetor.length-1; i >= 0; i--){
			System.out.println("\n Pos["+i+"] => " + vetor[i]);
		}
	}
	
	public static String entDados(String label){
		
		System.out.println(label);
		InputStreamReader c = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(c);
		String digitado = "";
		
		try{
			digitado = buf.readLine();
		}catch(IOException ioe){
			System.out.println("Ocorreu erro!");
		}
		return digitado;
	}
}