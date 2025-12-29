package exercicio1;

import java.io.File;

public class InfoDiretorio {
    
    public void dadosDiretorio(String path){
     
        File nome = new File(path);
        
        if (nome.exists()){   
            if (nome.isDirectory()){
                String diretorio[] = nome.list();

                System.out.println("\nMostrando Arquivos e pastas de " + path);
                
                for(int i = 0; i < diretorio.length; i++){
                    
                    File itemDoDiretorio = new File(path + "\\" + diretorio[i]);
                    
                    if (itemDoDiretorio.isDirectory()) {
                        System.out.println("\n" + diretorio[i] + " [diretório]");
                    } else 
                    if (itemDoDiretorio.isFile()){
                        System.out.println("\n" + diretorio[i] + " [arquivo]");
                    } 
                }
            } else {
                System.out.println("\nÉ um arquivo!");
            } 
        } else {
            System.out.println("\nDiretorio não existe!");
        }
    }
}
