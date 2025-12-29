package br.jsf;

import bri.CalcInteface;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */
@Named(value = "calcJSF")
@RequestScoped
public class CalcJSF {

    @EJB
    private CalcInteface calcEJB;

    private double numeroA;
    private double numeroB;
    private double resultadoSoma;
    private double resultadoSubtracao;
    private double resultadoMultiplicacao;
    private double resultadoDivisao;
    /**
     * Creates a new instance of CalcJSF
     */
    public CalcJSF() {
        
    }
    
    public void calcular(){
        try {
            resultadoSoma = calcEJB.somar(numeroA, numeroB);
            resultadoSubtracao = calcEJB.subtrair(numeroA, numeroB);
            resultadoMultiplicacao = calcEJB.multiplicar(numeroA, numeroB);
            
            if (numeroB == 0){
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
                            "Divisão por zero"));
                resultadoDivisao = 0;
            } else {
                resultadoDivisao = calcEJB.dividir(numeroA, numeroB);
            }
        
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de cálculo", 
                    ex.getMessage()));
        } 
    }

    public double getNumeroA() {
        return numeroA;
    }

    public void setNumeroA(double numeroA) {
        this.numeroA = numeroA;
    }

    public double getNumeroB() {
        return numeroB;
    }

    public void setNumeroB(double numeroB) {
        this.numeroB = numeroB;
    }

    public double getResultadoSoma() {
        return resultadoSoma;
    }

    public double getResultadoSubtracao() {
        return resultadoSubtracao;
    }

    public double getResultadoMultiplicacao() {
        return resultadoMultiplicacao;
    }

    public double getResultadoDivisao() {
        return resultadoDivisao;
    }
}
