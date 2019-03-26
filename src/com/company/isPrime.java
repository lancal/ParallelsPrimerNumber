package com.company;

import java.util.concurrent.atomic.AtomicInteger;



public class isPrime implements Runnable {

    private static final AtomicInteger PRIME = new AtomicInteger(0) ;

    long value;

    public isPrime(long value)
    {
        this.value = value;
    }

    @Override
    public void run() {

        boolean result = isAPrimeNumber();

//        if(result) {
//
//            PRIME.accumulateAndGet();
//        }

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
