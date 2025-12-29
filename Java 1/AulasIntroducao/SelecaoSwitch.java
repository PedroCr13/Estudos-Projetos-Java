public class SelecaoSwitch{
	public static void main(String args[]){
		
		int valor = (int)(Math.random()*5); //casting
		
		switch(valor){
			
			case 0:
			 System.out.println("Primeira opção (valor igual a zero)" + valor);
			 break;
			 
			case 1:
			 System.out.println("Segunda opção (valor igual a um) " + valor);
			 break;
			 
			default:
			 System.out.println("Outras opções (valor maior que um) " + valor);
			 break;
		}
	}
}