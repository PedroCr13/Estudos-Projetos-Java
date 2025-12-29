class ConstructorRefDemo {
	public static void main(String args[]){
		/*
			Cria uma referencia ao construtor MyClass
			ja que o metodo func() de MyFunc recebe o argumento
			new referencia o construtor parametrizado de MyClass
			e o não o construtor padrão
		*/
		MyFunc myClassCons = MyClass::new; //uma referencia de construtor
		
		//Cria uma instancia de MyClass usando essa referencia de construtor
		MyClass mc = myClassCons.func("Testing");
		
		//Usa a instância de MyClass recém criado
		System.out.println("str in mc is " + mc.getStr());
	}
}