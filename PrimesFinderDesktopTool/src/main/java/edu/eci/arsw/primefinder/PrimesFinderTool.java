package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {

	public static void main(String[] args) throws InterruptedException {
		            
            int maxPrim=1000;
            boolean sinterminar=true;
            PrimesResultSet prs=new PrimesResultSet("john"); 

            while(sinterminar){
                try {
                    //check every 10ms if the idle status (10 seconds without mouse
                    //activity) was reached. 
                    Thread.sleep(10);
                    PrimeFinder.findPrimes(new BigInteger("1"), new BigInteger("10"), prs);
                    sinterminar=PrimeFinder.getStatus();
                    
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                        System.out.println("Idle CPU ");         
                        
                        PrimeFinder.resume();
                        
                    }
                    else{
                        System.out.println("User working again!");
                        PrimeFinder.pausa();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             
            
            
            System.out.println("Prime numbers found:");
            
            System.out.println(prs.getPrimes());
            
	}
	
}


