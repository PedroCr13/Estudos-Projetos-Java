class GenIFDemo{
	public static void main(String args[]){
		
		Integer x[] = {1, 2, 3};
		
		MyClass<Integer> ob = new MyClass<Integer>(x);
		
		if(ob.contains(2))
			System.out.println("2 is in ob");
		else
			System.out.println("2 is NOT in ob");

		if(ob.contains(5))
			System.out.println("5 is in ob");
		else
			System.out.println("5 is NOT in ob");

	}
}