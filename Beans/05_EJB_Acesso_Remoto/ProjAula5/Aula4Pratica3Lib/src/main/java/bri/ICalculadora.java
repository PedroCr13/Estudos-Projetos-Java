package bri;

import jakarta.ejb.Remote;

/**
 *
 * @author pedro
 */
@Remote
public interface ICalculadora {
    public int somar(int a, int b);
}
