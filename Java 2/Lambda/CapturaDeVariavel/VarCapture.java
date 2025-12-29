//exemplo de captura de uma varíável local do escopo externo
class VarCapture {
	public static void main(String args[]){
		//uma varíável local que pode ser capturada
		int num = 10;
		
		MyFunc myLambda = (n) -> {
			//Este uso de num esta correto, não modifica num.
			int v = num + n;
			
			//não valida abaixo, tenta modificar num.
			//num++;
			return v;
		};
		//usa a expressão Lambda:
		System.out.println(myLambda.func(8));
		
		//abaixo ocorre erro remove de num o status final:
		//num = 9;
	}
}
