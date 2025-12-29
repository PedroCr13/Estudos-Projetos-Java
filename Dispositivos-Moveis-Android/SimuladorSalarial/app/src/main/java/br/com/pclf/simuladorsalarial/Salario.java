package br.com.pclf.simuladorsalarial;

public class Salario {
    private double salarioBase;
    private double salarioBruto;
    private double valorINSS;
    private double valorImpostoRenda;
    private double valorPrevidencia;
    private double baseCalculoIR;
    private double valorPlanoSaude;
    private double valorSindicato;
    private double valorAssociacao;
    private double valorValeTransporte;
    private int quantidadeDependentes;
    private int percContPrev;
    private double valorFGTS;
    public double getSalarioBase(){
        return salarioBase;
    }

    public double getSalarioBruto(){
        return salarioBruto;
    }

    public double getValorINSS() {
        return valorINSS;
    }

    public double getValorPrevidencia() {
        return valorPrevidencia;
    }

    public double getValorImpostoRenda(){
        return valorImpostoRenda;
    }

    public double getBaseCalculoIR(){
        return baseCalculoIR;
    }

    public int getQuantidadeDependentes(){
        return quantidadeDependentes;
    }

    public double getValorValeTransporte(){
        return valorValeTransporte;
    }

    public double getValorPlanoSaude(){
        return valorPlanoSaude;
    }

    public double getValorSindicato(){
        return valorSindicato;
    }

    public double getValorAssociacao(){
        return valorAssociacao;
    }

    public double getValorFGTS(){
        return valorFGTS;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    public void setSalarioBruto(double salarioBruto){
        this.salarioBruto = salarioBruto;
    }
    public void setValorINSS() {
        double faixa1 = 0, faixa2 = 0, faixa3 = 0, faixa4 = 0;

        if (salarioBruto <= 1518.00){
            faixa1 = salarioBruto * 0.075;
        } else if (salarioBruto >= 1518.01 && salarioBruto <= 2793.88) {
            faixa1 = 1518.00 * 0.075;
            faixa2 = (salarioBruto - 1518.00) * 0.09;
        } else if (salarioBruto >= 2793.89 && salarioBruto <= 4190.83) {
            faixa1 = 1518.00 * 0.075;
            faixa2 = 1275.87 * 0.09;
            faixa3 = (salarioBruto - 2793.89) * 0.12;
        } else if(salarioBruto >= 4190.84){
            faixa1 = 1518.00 * 0.075;
            faixa2 = 1275.87 * 0.09;
            faixa3 = 1396.94 * 0.12;

            if (salarioBruto <= 8157.41){
                faixa4 = (salarioBruto - 4190.84) * 0.14;
            } else  {
                faixa4 = 3966.57 * 0.14;
            }
        }
        valorINSS = faixa1 + faixa2 + faixa3 + faixa4;
    }
    public void setValorPrevidencia(){
        valorPrevidencia = (salarioBase * percContPrev)/100;
    }
    public void setPercContPrev(int percContPrev) {
        this.percContPrev = percContPrev;
    }
    public void setValorImpostoRenda() {

        double deducaoDependentes = 0;

        if (quantidadeDependentes > 0) {
            deducaoDependentes = quantidadeDependentes * 189.59;
        }

        baseCalculoIR = salarioBruto - valorINSS - valorPrevidencia - deducaoDependentes;

        if (baseCalculoIR <= 2259.20) {
            valorImpostoRenda = 0.00;
        } else if (baseCalculoIR >= 2259.21 && baseCalculoIR <= 2826.65) {
            valorImpostoRenda = (baseCalculoIR * 0.075) - 169.44;
        } else if (baseCalculoIR >= 2826.66 && baseCalculoIR <= 3751.05) {
            valorImpostoRenda = (baseCalculoIR * 0.15) - 381.44;
        } else if (baseCalculoIR >= 3751.06 && baseCalculoIR <= 4664.68) {
            valorImpostoRenda = (baseCalculoIR * 0.225) - 662.77;
        } else if (baseCalculoIR > 4664.68) {
            valorImpostoRenda = (baseCalculoIR * 0.275) - 896.00;
        }
    }
    public void setQuantidadeDependentes(int quantidadeDependentes){
        this.quantidadeDependentes = quantidadeDependentes;
    }
    public void setValorValeTransporte(){
        valorValeTransporte = salarioBase * 0.04;
    }
    public void setValorPlanoSaude(){
        double custoDependentes = 0, custoTitular = 0;
        double tetoMensalidade = salarioBase * 0.07;

        custoTitular = salarioBase * 0.035;

        if (quantidadeDependentes > 0){
            custoDependentes = quantidadeDependentes * 480.00;
        }

        valorPlanoSaude = custoTitular + custoDependentes;

        if (valorPlanoSaude > tetoMensalidade){
            valorPlanoSaude = tetoMensalidade;
        }
    }
    public void setValorSindicato(){
        valorSindicato = salarioBase * 0.01;
    }
    public void setValorAssociacao(){
        valorAssociacao = salarioBase * 0.01;
    }

    public void setValorFGTS(){
        valorFGTS = salarioBruto * 0.08;
    }

    public double salarioLiquido(){

        double liquido = salarioBruto - valorINSS - valorPrevidencia - valorImpostoRenda - valorPlanoSaude -
                valorSindicato - valorAssociacao - valorValeTransporte;

        return liquido;
    };
}
