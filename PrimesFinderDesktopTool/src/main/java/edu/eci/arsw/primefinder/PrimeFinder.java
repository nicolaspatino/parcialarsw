package edu.eci.arsw.primefinder;

import edu.eci.arsw.math.MathUtilities;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class PrimeFinder {
        private static PrimeFinderThread hilo1;
        private static PrimeFinderThread hilo2;
        private static PrimeFinderThread hilo3;
        private static PrimeFinderThread hilo4;
	public static void findPrimes(BigInteger _a, BigInteger _b, PrimesResultSet prs) throws InterruptedException{

                BigInteger a=_a;
                BigInteger b=_b;
                BigInteger c= b.divide(b.valueOf(4));
                BigInteger d= c.add(c);
                BigInteger e= d.add(c);   
               
                hilo1= new PrimeFinderThread(a,c,prs);  
                hilo2= new PrimeFinderThread(c,d,prs);
                hilo3= new PrimeFinderThread(d,e,prs);
                hilo4= new PrimeFinderThread(e,b,prs);
                
                hilo1.start();
                hilo1.join();
                hilo2.start();
                hilo2.join();
                hilo3.start();
                hilo3.join();
                hilo4.start(); 
                hilo4.join();
                
                

	}
        public static  boolean getStatus(){
            if (hilo1.isAlive() | hilo2.isAlive()| hilo3.isAlive() | hilo4.isAlive() ){
                return true;
            }
            else{
                return false;
            }
        }
        public static void pausa(){
            hilo1.pause();
            hilo2.pause();
            hilo3.pause();
            hilo4.pause();
   
        }
        public static void resume(){
            System.out.println("adios");
            hilo1.resumte();
            hilo2.resumte();
            hilo3.resumte();
            hilo4.resumte();
   
        }
	
}

