public class Logico{
	public static void main(String arg[]){
		
		int a = 0, c = 0, valor = 16;
		float b = 15;
		for(a=0; a < b; a++){
			valor--;
			c++;
			if(c<=(b/2) && c<=valor){
				System.out.println("C eh MENOR que a metade de B 'E' MENOR IGUAL A VALOR");
				System.out.println("C vale......: "+ c);
				System.out.println("B/2 vale....: "+ (b/2));
				System.out.println("VALOR vale..: "+ valor );
			}
			else if(c>=(b/2) || (c>= valor)){
				System.out.println("C eh maior que a metade de B 'OU' maior igual a VALOR");
				System.out.println("C vale......: "+ c);
				System.out.println("B/2 vale....: "+ (b/2));
				System.out.println("VALOR vale..: "+ valor );
			}
		}
	}
}