public class Gerente extends Funcionario{
    
    private String unidadeGerenciada;
    private double bonusMensal;
    
    public Gerente(){
        setSalario(0);
        setBonusMensal(0);
    }
 
    public Gerente(int matricula, String nome, double salario, String unidade){
        setMatricula(matricula);
        setNome(nome);
        setSalario(salario);
        setUnidadeGerenciada(unidade);    
    }
    
    public void setBonusMensal(double bonusMensal){
       this.bonusMensal = bonusMensal;
    }
    
    public double getBonusMensal(){
        return bonusMensal;
    }
    
    public void setUnidadeGerenciada(String unidade){
        unidadeGerenciada = unidade;
    }
    
    public String getUnidadeGerenciada(){
        return unidadeGerenciada;
    }
    
    public void atribuiPromocao(){
        double aumento = (getSalario() * 10)/100;
        setSalario(getSalario() +  aumento);
    }
}