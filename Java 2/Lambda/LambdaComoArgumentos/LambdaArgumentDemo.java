class LambdaArgumentDemo{
	/*
		tem uma interface funcional como tipo no seu primeiro parametro
		pode receber uma referencia a qualquer instancia desta interface
		segundo parametro especifica o string a ser alterado.
	*/
	static String changeStr(StringFunc sf, String s){
		return sf.func(s);
	}
	
	public static void main(String args[]){
		String inStr = "Lambda Expressions Expand Java";
		String outStr; //receberá string já modificado
		
		System.out.println("Here is input string: " + inStr);
		
		//Define uma expressão lambda que inverte o conteúdo de um 
		//string e a atibui a uma "variavel de referencia" StringFunc.
		//essa variavel posteriormente sera passada como argumento ao metodo.
		StringFunc reverse = (str) -> { //inicio bloco lambda
			String result = "";
			for(int i = str.length() -1; i >= 0; i--)
				result += str.charAt(i);
			return result;
		}; //fim bloco lambda
		
		//passa reverse como 1º argumento de changeStr()
		//passa o string de entrada como 2º argumento
		outStr = changeStr(reverse, inStr);
		System.out.println("The string reversed: " + outStr);
		
		//Esta expressão lambda substitui espaços por hifens
		//ela esta embutida diretamente na chamada a changeStr()
		outStr = changeStr((str) -> str.replace(' ', '-'), inStr);
		
		//Esta lambda de bloco inverte a caixa de caracteres String
		//ela também está embutida diretamente na chamada a changeStr().
		outStr = changeStr((str) -> {
							String result = "";
							char ch;
							
							for(int i = 0; i < str.length(); i++){
								ch = str.charAt(i);
								if(Character.isUpperCase(ch))
									result += Character.toLowerCase(ch);
								else
									result += Character.toUpperCase(ch);
							}
							return result;
						}, inStr);
			System.out.println("The string in reversed case: " + outStr);
		}
}