package bri;

import jakarta.ejb.Remote;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */

@Remote
public interface CalcInteface {
    public double somar(double a, double b);
    public double subtrair(double a, double b);
    public double multiplicar(double a, double b);
    public double dividir(double a, double b);
}
