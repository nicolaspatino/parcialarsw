package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;

import java.util.List;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
public class PrimeServiceStub implements PrimeService
{
    List<FoundPrime> found;
    @Override
    public void addFoundPrime( FoundPrime foundPrime )
    {
        found.add(foundPrime);
    }

    @Override
    public List<FoundPrime> getFoundPrimes()
    {
        return found;
    }

    @Override
    public FoundPrime getPrime( String prime ){
    FoundPrime encontrado = new FoundPrime();
        for (FoundPrime i :found){
            if (i.getPrime().equals(prime)){
                encontrado=i;
            }  
        }
      return encontrado;
    }
}
