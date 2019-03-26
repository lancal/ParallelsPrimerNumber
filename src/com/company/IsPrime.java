package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IsPrime implements Runnable {

    private static final long UPPER_BOUND=100000000;

    long value;//the number observed

    private IsPrime(long value)
    {
        this.value=value;
    }

    private boolean isAPrimeNumber()
    {
        if(value==1 || value==2) return true;
        if(value%2L==0) return false;
        for(long i=3;i<= value / 2;++i)
        {
            if(this.value%i==0) return false;
        }
        return true;
    }

    @Override
    /** calls isAPrimeNumber */

    public void run()
    {
        boolean result=isAPrimeNumber();
        if(result) System.out.println("["+this.value+"]");
    }

    /** loop from 3 to UPPER_BOUND, multithreaded */
    public static long loopMultiThread()
    {
        long now = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(2);

        for(long i=3;i< UPPER_BOUND;i+=2)
        {
            service.submit(new IsPrime(i));
        }
        service.shutdown();
        return System.currentTimeMillis()-now;
    }



}
