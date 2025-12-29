/*T é nome do Espaço reservado para o tipo real que 
será passado quando um objeto for criado*/
class Gen<T>{  
	T ob;

	Gen(T o){
		ob = o;
	}
	
	T getOb(){
		return ob;
	}
	
	void showType(){
		System.out.println("Type of T is " + ob.getClass().getName());
	}
}