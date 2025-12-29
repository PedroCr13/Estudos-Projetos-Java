public class GenDemo{
	public static void main(String args[]){
		//versão Gen para inteiros
		Gen<Integer> iOb;  //parametrizado o objeto, "gen inteiro"
		
		iOb = new Gen<Integer>(88); // atribui referencia do tipo Integer a iOb
		iOb.showType();
		
		int v = iOb.getOb();
		System.out.println("value: " + v);
		
		Gen<String> strOb = new Gen<String>("Generic Test String");
		strOb.showType();
	
		String str = strOb.getOb();
		System.out.println("Value: " + str);
		
		// demonstra TwoGen: classe generica com 2 parametros.
		TwoGen<Integer, String> tgobj =
			new TwoGen<Integer, String>(88, "Genericos");
		
		tgobj.showTypes();
		
		int v2 = tgobj.getOb1();
		System.out.println("Value: " + v2);
		
		String str2 = tgobj.getOb2();
		System.out.println("Value " + str2);
	}
}