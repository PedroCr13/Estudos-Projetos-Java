//Exceção para erros de fila vazia.
public class QueueEmptyException extends Exception{
	
	public String toString(){
		return "\nQueue is empty.";
	}
}