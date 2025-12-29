//Uma lambda de bloco que encontra o menor fator positivo
//de um valor de int 
//exemplo lambda de bloco 
//mais de uma instrução dentro de uma lambda
class BlockLambdaDemo{
	public static void main(String args[]){
		//Esta lambda de bloco retorna o menor fator positivo de um valor
		NumericFunc smallestF = (n) -> { //inicio do corpo lambda
			int result = 1;
			//obtem o valor absoluto de n
			n = n < 0 ? -n : n;
			
			for(int i = 2; i <= n; i++)
				if((n % i) == 0){
					result = i;
					break;
				}
			return result;
		}; //fim corpo expressao lambda
		
		System.out.println("Smallest factor of 12 is " + smallestF.func(12));
		System.out.println("Smallest facotr if 11 is " + smallestF.func(11));
	}
}