public class Stringe{

	public static void main(String args[]){
		
		String frase = "Eis-me aqui SENHOR, envia-me a miM";
		System.out.println("\t\t\t\t Eis-me aqui SENHOR, envia-me a mim");
		System.out.println("\n\n Qtd de caracaters: " + frase.length());
		System.out.println("\n\n A frase inteira em maiscula: " + frase.toUpperCase());
		System.out.println("\n\n Frase em minusculas: " + frase.toLowerCase());
		System.out.println("\n\n Letra na 10 posicao: " + frase.charAt(13));
		System.out.println("\n\n Substring dentro da frase: " + frase.substring(0, 11));
		System.out.println("\n\n Primeira ves que encontrou O na frase: "+ frase.indexOf('O'));
		System.out.println("\n\n Sem espaços em braco: " + frase.trim());
		System.out.println("\n\n Trocando m por M: " + frase.replace('m','M'));
		System.out.println("\n\n Comapara Frases: " + frase.compareTo("M"));
	}

}