class BoundsDemo {
	public static void main(String args[]){
		NumericFns<Integer> iOb = 
			new NumericFns<Integer>(6);
			
		System.out.println("Reciprocal of iOb is " +
			iOb.reciprocal());
		
		System.out.println("Fractional component of iOb is " +
			iOb.fraction());
			
		System.out.println();
		
		NumericFns<Double> dOb = 
			new NumericFns<Double>(5.25);
		
		System.out.println("Fractional of dOb is " +
			dOb.reciprocal());	

		//Aceita apenas Number ou subclasse de Numbe (ex Integer)
		Pair<Number, Integer> x = new Pair<Number, Integer>(10.4, 12);
		
	}
}