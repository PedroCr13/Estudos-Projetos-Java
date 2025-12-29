class MyClass{
	private String str;
	
	//Este construtor recebe um argumento
	MyClass(String s){
		str = s;
	}
	
	//Construtor padrão
	MyClass(){
		str = "";
	}
	
	String getStr(){
		return str;
	}
}