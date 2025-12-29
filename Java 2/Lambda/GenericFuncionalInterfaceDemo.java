class GenericFuncionalInterfaceDemo{
	public static void main(String args[]){
		//lambda determina se um inteiro é fator de outro
		SomeTest<Integer> isFactor = (n, d) -> (n % d) == 0;
		
		if(isFactor.test(10, 2))
			System.out.println("2 is a factor of 10");
		System.out.println();
		
		//lambda determina se double é fator de outro
		SomeTest<Double> isFactorD = (n, d) -> (n % d) == 0;
		
		if(isFactorD.test(212.0, 4.0))
			System.out.println("4.0 is factor of 212.0");
		System.out.println();
		
		//Lambda determina se String faz parte de outra:
		SomeTest<String> isIn = (a, b) -> a.indexOf(b) != -1;

		String str = "Generic Functional Interface";
		
		System.out.println("Testing String: " + str);
		
		if(isIn.test(str, "face"))
			System.out.println("'face' is found.");
		else
			System.out.println("'face' not found");
	}
}