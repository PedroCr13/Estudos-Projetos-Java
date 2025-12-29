//Interface de fila genérica
//o tipo de dado armazenado na fila
//é do tipo genérico T
public interface IGenQ<T> {
	//Insere um item na fila
	void put(T ch) throws QueueFullException;
	
	//Retira um item da fila
	T get() throws QueueEmptyException;
}