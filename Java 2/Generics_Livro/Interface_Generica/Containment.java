//Exemplo de interface genérica
interface Containment<T extends Number>{
	//verifica se um item especificado esta contido
	//dentro de um objeto que implementa a interface
	boolean contains(T o);
}