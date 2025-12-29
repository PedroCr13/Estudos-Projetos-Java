/*
	Calcula a soma dos quadrados de todos os numeros inteiros 
	impares na lista, usando stream
*/
import java.util.Arrays;
import java.util.List;

public class MainStreamDemo {
	public static void main(String args[]){
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		//loop internamente por stream
		int sum = numbers.stream()
			.filter(n -> n % 2 == 1)
			.map(n -> n * n)
			.reduce(0, Integer::sum);
			
		System.out.println(sum);
	}
}