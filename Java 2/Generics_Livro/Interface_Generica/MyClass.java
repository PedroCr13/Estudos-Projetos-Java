/*
	Tipo limitado a subclasses Number (ela inclusive)
*/
class MyClass<T extends Number> implements Containment<T>{
	T[] arrayRef;
	
	MyClass(T[] o){
		arrayRef = o;
	}
	
	//implments contains
	public boolean contains(T o){
		for(T x: arrayRef)
			if(x.equals(o)) return true;
		return false;
	}
}