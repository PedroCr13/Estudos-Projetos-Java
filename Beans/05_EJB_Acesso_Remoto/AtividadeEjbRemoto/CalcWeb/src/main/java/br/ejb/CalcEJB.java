package br.ejb;

import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */
@Stateless
@LocalBean
public class CalcEJB implements bri.CalcInteface {

    @Override
    public double somar(double a, double b) {
        return a + b;
    }

    @Override
    public double subtrair(double a, double b) {
        return a - b;
    }

    @Override
    public double multiplicar(double a, double b) {
        return a * b;
    }

    @Override
    public double dividir(double a, double b) {
       return a / b;
    }
}
