public class Matrz{
	
	public static void main(String arg[]){
		
		int lin = 5, col = 5, cont = 1;
		
		int mtrz[][] = new int[lin][col];
		
		System.out.println("Tamanho da Matriz: " + mtrz.length);
		
		for (int l = 0; l < lin; l++){
			for (int c = 0; c < col; c++){
				mtrz[l][c] = cont++;
			}
		}
		
		for(int l = 0; l < lin; l++){
			for(int c = 0; c < col; c++){
				System.out.println("O valor da "+l+"ª linha e "+c+"ª coluna eh "+mtrz[l][c]);
			}
		}
	}

}