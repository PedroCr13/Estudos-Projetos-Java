public class LacoWhile {
	public static void main(String args[]){
		int a = 0, b = 15;
		while(a <= b){
			b--;
			System.out.println("O valor de B dentro do While é: " + b);
		}

		System.out.println("\n Do while");
		
		int x = 0, y = 15;
		do{
			y--;
			System.out.println("O valor de x dentro do While é: " + y);
		}while(x <= y);
		System.out.println("");
	}
}