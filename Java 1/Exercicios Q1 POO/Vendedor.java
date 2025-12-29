public class Vendedor extends Funcionario{
    
    private double comissao;
    
    public Vendedor(){
        setSalario(0);
        setComissao(0);
    }
    
    public Vendedor(int matricula, String nome, double salario){
        setMatricula(matricula);
        setNome(nome);
        setSalario(salario);
    }
    
    public double getComissao(){
        return comissao;
    }
    
    public void setComissao(double comissao){
        this.comissao = comissao;
    }
    
    public void atribuiPromocao(){
        double aumento = (getSalario() * 6)/100;
        setSalario(getSalario() +  aumento);
    }
}