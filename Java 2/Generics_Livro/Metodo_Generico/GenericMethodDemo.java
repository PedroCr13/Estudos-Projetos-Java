//demonstra um metodo generico simples
class GenericMethodDemo{
	
	//determina se o conteudo de dois arrays é igual
	static <T extends Comparable<T>, V extends T> boolean
		arraysEqual(T[] x, V[] y){
		// se o tamanho dos arrays for diferente, arrays serao
		if (x.length != y.length) return false;
		
		for(int i = 0; i < x.length; i++)
			if(!x[i].equals(y[i])) return false; //arrays diferentes
		
		return true; //conteudos equivalentes
	}
	
	public static void main(String args[]){
		
		Integer nums[] = { 1, 2, 3, 4, 5};
		Integer nums2[] = { 1, 2, 3, 4, 5};
		Integer nums3[] = {1, 2, 7, 4, 5};
		Integer nums4[] = {1, 2, 7, 4, 5, 6};
		
		if(arraysEqual(nums, nums))
			System.out.println("nums equals nums");
		
		if (arraysEqual(nums, nums2))
			System.out.println("nums equals nums2");
		
		if (arraysEqual(nums, nums3))
			System.out.println("nums equals nums3");
		
		if (arraysEqual(nums, nums4))
			System.out.println("nums equals nums4");
		
		//Cria arrays de Doubles
		Double dvals[] = {1.1, 2.2, 3.3, 4.4, 5.5};
		
		//if (arraysEqual(num, dvals))
		//	System.out.println("nums equals dvals");
	}
}