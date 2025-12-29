class MethodRefDemo {
	/*
		este metodo tem uma interface funcional como tipo do seu 
		primeiro parametro. 
		Pode receber uma referência a qualquer instancia desta interface
		inclusive uma criada por uma referência de metodo.
	*/
	static boolean numTest(IntPredicate p, int v){
		return p.test(v);
	}
	
	public static void main(String args[]){
		boolean result;
		
		//Aqui, uma referência ao metodo isPrime() passada para numTest()
		result = numTest(MyIntPredicate::isPrime, 17);
		if(result) System.out.println("17 is prime!");
		
		//agora, uma referencia ao metodo isEven é usada
		result = numTest(MyIntPredicate::isEven, 12);
		if(result) System.out.println("12 is even!");
		
		//uma referência ao metodo isPositive é passada
		result = numTest(MyIntPredicate::isPositive, 11);
		if(result) System.out.println("11 is positive!.");
	}
}