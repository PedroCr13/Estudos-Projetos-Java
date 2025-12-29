//Classe genérica para um fila de tamanho fixo.
//classe generica com parametro T (especifica 
//o tipo de dado armazenado na fila
//T também é passado para a interface IGenQ
public class GenQueue<T> implements IGenQ<T>{
	private T q[]; //arra que contem a fila
	private int putloc, getloc; //indices de inserção e retirada
	
	//constrói uma fila vazia como o array dado
	//recebe o array (criar o array de tipo compativel 
	//antes para passar)
	//por exemplo: String strArray[] new String[10];
	//GenQueue<String> strQ = new GenQueue<String>(strArray);
	public GenQueue(T[] aRef){
		q = aRef;
		putloc = getloc = 0;
	}
	
	//Insere um item na fila:
	public void put(T obj) throws QueueFullException{
		if(putloc == q.length)
			throw new QueueFullException(q.length);
		
		q[putloc++] = obj;
	} 
	
	//Retira um item da fila:
	public T get() throws QueueEmptyException{
		if(getloc == putloc)
			throw new QueueEmptyException();
		
		return q[getloc++];
	}
}