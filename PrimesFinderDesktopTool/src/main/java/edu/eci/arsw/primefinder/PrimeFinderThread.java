/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.primefinder;

import edu.eci.arsw.math.MathUtilities;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2112712
 */
public class PrimeFinderThread extends Thread {
    private BigInteger _a;
    private BigInteger _b;
    private PrimesResultSet prs;
    private boolean pause=false;
   
    
       public PrimeFinderThread(BigInteger _a, BigInteger _b, PrimesResultSet prs){
            this._a=_a;
            this._b=_b;
            this.prs=prs;
       }
       
       @Override
       public void run(){
           
           if (pause==false){
           BigInteger a=_a;
           BigInteger b=_b;
                MathUtilities mt=new MathUtilities();
                
                int itCount=0;
            
                BigInteger i=a;
                while (i.compareTo(b)<=0){
                    itCount++;
                    if (mt.isPrime(i)){
                        prs.addPrime(i);
                        
                    }

                    i=i.add(BigInteger.ONE); 
       }
           }
           else{
               try {
                   synchronized(this){
                   this.wait();
                   
                   }
               } catch (InterruptedException ex) {
                   Logger.getLogger(PrimeFinderThread.class.getName()).log(Level.SEVERE, null, ex);
               }
           }  
       }
       public void pause(){
           System.out.println("pausa");
           pause=true;
       }
       public void resumte(){
           System.out.println("resume");
           synchronized(this){
               this.notifyAll();
           }
       }
}
    

