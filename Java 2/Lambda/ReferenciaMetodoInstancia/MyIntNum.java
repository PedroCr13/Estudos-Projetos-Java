/*
	Esta classe armazena um valor int e define o método de 
	instância isFactor(), que retorna true quando seu argumento é 
	fator do valor armazenado.
*/
class MyIntNum {
	private int v;
	
	MyIntNum(int x) {
		v = x;
	};
	
	int getNum(){
		return v;
	}
	
	//Retorna true se n for fator de v.
	boolean isFactor(int n){
		return (v % n) == 0;
	}
}