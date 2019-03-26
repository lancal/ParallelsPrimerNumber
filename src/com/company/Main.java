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

    private static final long UPPER_BOUND = 600 * 1000;

    /**
     *
     * Constante de Numero de hilos.
     *
     */

    private static final int NTHREADS = 4;

    /**
     *
     * Constante de tiempo maximo de espera
     *
     */
    private static final int MAXTIME = 120;

    public static boolean isAPrimeNumber(long value) {

        if(value==1 || value==2) {

            return true;

        }

        if(value%2L==0) {

            return false;

        }

        for(long i=3; i<= value / 2; ++i) {

            if(value%i==0) return false;

        }

        return true;
    }

    public static void main(String[] args) throws InterruptedException {

        for (int primeNumbers=(100*1000); primeNumbers <= UPPER_BOUND; primeNumbers += (100*1000)) {

            double parallelTimeT1 = 0;

            System.out.println("Cantidad limite: " + primeNumbers);

            for (int cantThreads = 1; cantThreads <= NTHREADS; cantThreads++) {

                long now = System.currentTimeMillis();

                ExecutorService service = Executors.newFixedThreadPool(NTHREADS);

                for (int i = 2; i <= primeNumbers; i++) {

                    service.submit(new isPrime(i));

                }

                service.shutdown();
                service.awaitTermination(MAXTIME, TimeUnit.HOURS);

                long endTime = System.currentTimeMillis() - now;

                double parallelTime = (double) endTime;

                if (cantThreads == 1) {

                    parallelTimeT1 = parallelTime;

                }

                double speedup = (double) parallelTimeT1 / parallelTime;

                System.out.println("Hilos " + cantThreads + " Tiempo: " + parallelTime + " milisegundo Speed-Up: " + speedup + " segundos por hilos");

            }

        }

    }
}
