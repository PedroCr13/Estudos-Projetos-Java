public class TestLambda{
	public static void main(String args[]){
		MyValue myVal; //referencia do tipo interface
		
		//expressão lambda em contexto de atribuição
		//a um metodo abstrato de interface
		//myVal inicializada com expressão lambda
		//expressão passou a ser a implementação 
		//do metodo getValue() da interface 
		//cria automaticamente a instancia da classe
		//vai na interface procurar o unico metodo abstrato que 
		//não recebe parametro e retorna double
		myVal = () -> 98.6;
		
		//chama o metodo getValue() por intermédio de myVal (referencia da interface)
		System.out.println("A constant value: " + myVal.getValue());
		
		//com mais de um parametro no metodo da interface, 
		//a expressão lambda tambem deve ter a mesma qtd de parametros
		//metodo da interface implementado pela expressão lambda recebendo parametro 4
		MyParamValue myPal = (n) -> 1.0/n;
		System.out.println("Reciprocal of 4 is " + myPval.getValue(4.0));
	}
}