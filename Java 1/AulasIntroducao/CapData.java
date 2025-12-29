import java.util.GregorianCalendar;

public class CapData {
	
	public static void main(String args[]){
		
		GregorianCalendar data = new GregorianCalendar();
		
		int dia = data.get(data.DAY_OF_MONTH);
		int mes = data.get(data.MONTH)+1;
		int ano = data.get(data.YEAR);
		
		int hora = data.get(data.HOUR);
		int minuto = data.get(data.MINUTE);
		int segundo = data.get(data.SECOND);
		
		System.out.println("\nData atual do sistema:"+dia+"/"+mes+"/"+ano+"\n\n");
		System.out.println("\nData atual do sistema: "+data.get(data.DAY_OF_MONTH)+
			"/"+data.get(data.MONTH)+"/"+data.get(data.YEAR)+"\n\n");
		System.out.println("\nHora: "+hora+" minuto: "+minuto+" segundos: "+segundo);
	}
	
}
