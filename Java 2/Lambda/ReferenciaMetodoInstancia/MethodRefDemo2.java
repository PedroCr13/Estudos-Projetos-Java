class MethodRefDemo2 {
	public static void main(String args[]){
		boolean result;
		
		MyIntNum myNum = new MyIntNum(12);
		MyIntNum myNum2 = new MyIntNum(16);
		
		//aqui, uma referência ao metódo isFactor é criada em myNum.
		IntPredicate ip = myNum::isFactor;
		
		//agora ela é usada para chamar isFactor() via test()
		result = ip.test(3);
		if(result) System.out.println("3 is a factor of: " + myNum.getNum());
		
		//desta vez a referência ao metodo isFactor() é criada em myNum2
		//e usada para chamar isFactor() via test().
		ip = myNum2::isFactor;
		result = ip.test(3);
		if(!result) System.out.println("3 is not a factor of: " + myNum2.getNum());
	}
}