/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package br.ejb;

import jakarta.ejb.Local;

/**
 *
 * @author pedro
 */
@Local
public interface EjbLocalLocal {
    
    // classe 100% abstrata (interface)
    
    // para ser acessado por meio do EJB, deve ter os metodos explicitados aqui
    public int dobrar(int valor);
    
}
