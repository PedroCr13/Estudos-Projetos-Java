package com.aula6.exemplo_isAlive;

/**
 *
 * @author Usuario
 */
public class MyThread implements Runnable{
    
    Thread thrd;
    
    public MyThread(String nome){
        thrd = new Thread(this, nome);
        thrd.start();
    }
    
    
    public void run(){
        
    }
}
