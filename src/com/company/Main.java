package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author Alan Calderon
 *
 */

public class Main {

    /**
     *
     * Constante de limite superior de numeros.
     *
     */

    private static final long UPPER_BOUND = 1000 * 1000;

    /**
     *
     * Constante de Numero de hilos.
     *
     */

    private static final int NTHREADS = 2;

    /**
     *
     * Constante de tiempo maximo de espera
     *
     */
    private static final int MAXTIME = 120;

    public static void main(String[] args) throws InterruptedException {

        long parallelTimeT1 = 0;

        for(int cantThreads = 1; cantThreads <=  NTHREADS; cantThreads++) {

            long now = System.currentTimeMillis();

            ExecutorService service = Executors.newFixedThreadPool(NTHREADS);

            for(int i = 2;i <= UPPER_BOUND;i++) {

                service.submit(new isPrime(i));

            }

        service.shutdown();
        service.awaitTermination(MAXTIME, TimeUnit.HOURS);

        if (service.isTerminated()){

            long endTime = System.currentTimeMillis() - now;

            long seconds = (endTime / 1000);

            System.out.println("Finished in " + seconds + " seconds");

            long parallelTime = endTime;

            if (cantThreads == 1) {

                parallelTimeT1 = parallelTime;

            }

            long speedup = parallelTimeT1 / parallelTime;

            System.out.println("Speed-Up: "+ speedup + " seconds/tasks");

            }
        }

    }
}
