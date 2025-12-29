class UseBoundedWildCard{
	//aqui o simbolo ? equivalerá a A ou a
	//qualquer tipo de classe que estenda A.
	static void test(Gen<? extends A> o){
			//...
	}
	
	public static void main(String args[]){
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		
		Gen<A> w = new Gen<A>(a); //a
		Gen<B> w2 = new Gen<B>(b);//herda de a
		Gen<C> w3 = new Gen<C>(c);//herda de a
		Gen<D> w4 = new Gen<D>(d);//não herda de a
		
		test(w);
		test(w2);
		test(w3);
		
		test(w4);
	}

}