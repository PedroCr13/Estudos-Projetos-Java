public class Teste{

	public static void main(String args[]){
		
		Pai p = new Pai();
	
		p.nome = "Pedro";
		p.idade = 28;
		//p.salario = 1000;
		
		System.out.println("\nNome: " + p.nome);
		System.out.println("Idade:" + p.idade);
		
		p.cadPai("Antonio", 30, 1500);
		
		p.impPai();
		
		//p.calcSalario();
	}

}