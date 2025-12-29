public class Matem{
	public static void main(String args[]){
		
		double f = 2;
		double g = 1.34;
		double h = 9;
		
		System.out.println("\n O seno de var 'f' eh: " + Math.sin(f));
		System.out.println("\n O cosseno de var 'f' eh: " + Math.cos(f));
		System.out.println("\n A tangente de var 'f' eh: " + Math.tan(f));
		System.out.println("\n O valor minimo entre as var f e g eh: " + Math.min(f, g));
		System.out.println("\n O valor maximo entre as var f e g eh " + Math.max(f, g));
		System.out.println("\n O valor arredondado de g eh: " + Math.round(g));
		System.out.println("\n O valor arredondado para cima de g(1.434) eh " + Math.ceil(g));
		System.out.println("\n O valor arrendondado para baixdo de var g(1.434) eh " + Math.floor(g));
		
		System.out.println("\n A raiz da var h eh " + Math.sqrt(h) );
		System.out.println("\n A var f elevada a h eh" + Math.pow(f, h));
		System.out.println("\n O valor absoluto da var g(1.434) eh " + Math.abs(g));
		System.out.println("\n O valor de Pi eh: " + Math.PI);
		System.out.println("\n Gerar um valor aleatorio entre 0 e 1: " + Math.random());
		
		System.out.println("\n A ultima linha nao faz parte da classe Math, o operador Modulo");
		System.out.println("\n O resto da divisao entre as vars h e f eh: " + (f%h));
		
	}
}