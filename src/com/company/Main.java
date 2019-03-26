package com.company;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final long UPPER_BOUND = 1000000;

    private static final int NTHREADS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        ExecutorService service = Executors.newFixedThreadPool(NTHREADS);

        for(long i=2;i <= UPPER_BOUND;i++)
        {
            service.submit(new IsPrime(i));
        }

        service.shutdown();

        long endTime = System.currentTimeMillis()-now;

        long seconds = (endTime / 1000);

        System.out.println("Finished in " + seconds + " seconds");

        long speedup = (seconds / NTHREADS);

        System.out.println("Speed-Up: "+speedup+" seconds/tasks");



    }
}
