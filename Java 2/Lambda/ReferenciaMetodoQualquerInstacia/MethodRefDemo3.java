class MethodRefDemo3 {
	public static void main(String args[]){
		boolean result;
		
		//Objeto da classe concreta. 
		MyIntNum myNum = new MyIntNum(12);
		
		MyIntNum myNum2 = new MyIntNum(16);
		
		//esta instrução faz inp referenciar o método de 
		//instância isFactor()
		MyIntNumPredicate inp = MyIntNum::isFactor; //referencia de metodo para qualquer objeto MyIntNum
		
		//a instrução a seguir chama isFactor() em myNum
		//myNum passa a ser o objeto em que isFactor(3) é chamado
		result = inp.test(myNum, 3);
		if(result)
			System.out.println("3 is factor of " + myNum.getNum());
		
		//a proxima instrução chama isFactor() em myNum2
		result = inp.test(myNum2, 3);
		if(!result)
			System.out.println("3 is a not a factor of " + myNum2.getNum());
	}
}