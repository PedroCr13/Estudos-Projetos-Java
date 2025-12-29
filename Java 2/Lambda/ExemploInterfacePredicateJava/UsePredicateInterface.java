/*
	use a interface funcional interna Predicate
	o metodo abstrato de Predicate se chama test()
	             boolean test(T val)
	retorna true se val estiver de acordo com alguma restrição ou condição
	no exemplo abaixo retornará true se val for par.
*/
//importa a interface predicate
import java.util.function.Predicate;

class UsePredicateInterface {
	
	public static void main(String args[]){
		//Esta expressão lambda usa Predicate<Integer> para
		//determinar se um numero é par
		Predicate<Integer> isEven = (n) -> (n % 2) == 0; //usa interface interna Predicate
		
		if(isEven.test(4))
			System.out.println("4 is even!");
		
		if(!isEven.test(5))
			System.out.println("5 is odd!");
	}
}
