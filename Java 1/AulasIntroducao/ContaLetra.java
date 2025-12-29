 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.io.IOException;
 
 public class ContaLetra {
	
	public static void main(String args[]){
		
		String frase, letra, resp = "s";
		int posLetra = -1;
		do{	
			frase = entDados("\nDigite uma frase!");
			
			System.out.println("A frase eh: " + frase);
			
			letra = entDados("\nAgora digite uma letra da frase: ");
			
			posLetra = frase.indexOf(letra);
			
			if (posLetra == -1){
				System.out.println("\nLetra nao localizada!");
			} else {
				System.out.println("\n A primeira ocorrencia da letra esta na pos: " + posLetra);
				
				int contaOcorrencias = 0;		
				
				for (int i = posLetra; i < frase.length(); i++){
					
					String let = Character.toString(frase.charAt(i));
					
					if (let.compareTo(letra) == 0){
						contaOcorrencias++;
					}
				}
				
				System.out.println("\n A letra "+letra+" aparece "+contaOcorrencias+" vezes.");
			}
			
			resp = entDados("Deseja repetir? s sim n nao");
				
				
		}while(resp.compareTo("s") == 0); 
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