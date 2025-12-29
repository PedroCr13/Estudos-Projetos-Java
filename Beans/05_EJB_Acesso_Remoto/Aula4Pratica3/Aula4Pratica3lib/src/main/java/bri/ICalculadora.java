package bri;

import jakarta.ejb.Remote;

/**
 *
 * @author Pedro Cristovao Lopes Fogaca
 */
@Remote
public interface ICalculadora {
    public int somar(int a, int b);
}
