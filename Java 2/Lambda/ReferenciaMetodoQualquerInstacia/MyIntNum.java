/*
	esta classe armazena um valor int e define o metodo
	de instancia isFactor(), que retorna true quando seu 
	argumento é fator do valor armazenado
*/
class MyIntNum {
	private int v;
	
	public int getNum(){
		return v;
	}
	
	MyIntNum(int x){
		v = x;
	}
	
	//retorna true se n for fator de v.
	boolean isFactor(int n){
		return (v % n) == 0;
	}
}
