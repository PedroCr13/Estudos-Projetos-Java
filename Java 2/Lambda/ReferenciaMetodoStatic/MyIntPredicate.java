/*
	Esta classe define 3 metodos estaticos que 
	verificam um inteiro em relação a alguma condição
*/
class MyIntPredicate{
	//metodo estatico retorna true quando numero é primo
	static boolean isPrime(int n){
		if(n < 2) return false;
		
		for(int i=2; i <= n/i; i++){
			if((n % i) == 0)
				return false;
		}
		return true;
	}
	
	//metodo estatico que retorna true quando numero é par
	static boolean isEven(int n){
		return (n % 2) == 0;
	}
	
	//metodo estatico que retorna true quando numero é positivo
	static boolean isPositive(int n){
		return n > 0;
	}
}