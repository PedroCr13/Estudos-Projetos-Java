class NumericFns<T extends Number>{
	T num;
	
	//passa referencia a um obj numerico
	NumericFns(T n){
		num = n;
	}
	
	double reciprocal(){
		return 1 / num.doubleValue();
	}
	
	double fraction(){
		return num.doubleValue() - num.intValue();
	}
	
	/* Determina se o valor absoluto de dois objetos sao iguais
	   <?> qualquer objeto NumericFns independnete do tipo passado
	*/
	boolean absEqual(NumericFns<?> ob){
		if (Math.abs(num.doubleValue()) == 
		Math.abs(ob.num.doubleValue())) return true;
		
		return false;
	}
}