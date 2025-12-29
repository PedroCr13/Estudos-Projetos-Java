public class TstQuestionarioI {
    
    public static void main(String args[]){
        
        Gerente gerente1 = new Gerente(15, "Rodolfo", 1000, "Loja 1"); 
        gerente1.atribuiPromocao();
        
        System.out.println("\nMatricula: " + gerente1.getMatricula());
        System.out.println("\nNome: " + gerente1.getNome());
        System.out.println("\nSalario: " + gerente1.getSalario());
        System.out.println("\nBonus: " + gerente1.getBonusMensal());
        System.out.println("\nUnidade: " + gerente1.getUnidadeGerenciada());
        
        Vendedor vendedor1 = new Vendedor(18, "Joao", 800);
        vendedor1.atribuiPromocao();
                
        System.out.println("\nMatricula: " + vendedor1.getMatricula());
        System.out.println("\nNome: " + vendedor1.getNome());
        System.out.println("\nSalario: " + vendedor1.getSalario());
        System.out.println("\nComissao: " + vendedor1.getComissao()); 
    }  
}