package com.company;

public class IsPrime implements Runnable {

    long value;//the number observed

    public IsPrime(long value)
    {
        this.value=value;
    }

    @Override
    public void run()
    {
        boolean result = isAPrimeNumber();
        if(result) System.out.println("Is Prime: [" + this.value + "]");

    }

    public boolean isAPrimeNumber()
    {
        if(value==1 || value==2) return true;
        if(value%2L==0) return false;
        for(long i=3; i<= value / 2; ++i)
        {
            if(this.value%i==0) return false;
        }

        return true;
    }





}
