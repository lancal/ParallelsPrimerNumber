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

    private static final int NTHREADS = 16;

    /**
     *
     * Constante de tiempo maximo de espera.
     *
     */
    private static final int MAXTIME = 120;

    /**
     *
     * funcion que comprueba si un numero es primo.
     *
     * @param value
     * @return
     */

    public static boolean isAPrimeNumber(long value) {


        int remainder;
        for (int i = 2; i <= value ; i++) {
            remainder = (int) (value % i);
            //if remainder is 0 than numberToCheckber is not prime and break loop. Elese continue loop
            if (remainder == 0) {
                return false;
            }
        }
        return true;

    }

    /**
     *
     * Funcion main, comienza la ejecucion del programa.
     *
     * @param args
     * @throws InterruptedException
     */

    public static void main(String[] args) throws InterruptedException {

        /**
         *
         * Primer for que va de 100k en 100k hasta 600k.
         *
         */

        for (int primeNumbers=(100*1000); primeNumbers <= UPPER_BOUND; primeNumbers += (100*1000)) {

            /**
             *
             * Se declara e inicializa una variable, para guardar el tiempo de un thread.
             *
             */

            double parallelTimeT1 = 0;

            /**
             *
             * Se imprime por pantalla 100k,200k...600k.
             *
             */

            System.out.println("Cantidad limite: " + primeNumbers);

            /**
             *
             * Este for va desde 1 threads hasta 16 para comprobar si primo un numero.
             *
             */

            for (int cantThreads = 1; cantThreads <= NTHREADS; cantThreads++) {

                /**
                 *
                 * Se guarda el tiempo actual en milisegundos.
                 *
                 */

                long now = System.currentTimeMillis();

                /**
                 *
                 * Se inicia una instancia de service con la cantidad de threads en cada pasada del for.
                 *
                 */

                ExecutorService service = Executors.newFixedThreadPool(cantThreads);

                /**
                 *
                 * En este for se itera cada 100k numeros, hasta 600k
                 *
                 */

                for (int i = 2; i <= primeNumbers; i++) {

                    service.submit(new isPrime(i));

                }

                /**
                 *
                 * Service apaga todos los procesos de hilos corriento.
                 *
                 */

                service.shutdown();

                /**
                 *
                 * Se espera una cierta cantidad de tiempo hasta que se termine de ejecutar todos los hilos.
                 *
                 */

                service.awaitTermination(MAXTIME, TimeUnit.SECONDS);

                /**
                 *
                 * Se calcula el tiempo actual menos el que se obtuvo antes de empezar la ejecucion de los hilos.
                 *
                 */

                long endTime = System.currentTimeMillis() - now;

                /**
                 *
                 * Se guarda el tiempo calculdo y se guarda en otra variable.
                 *
                 */

                double parallelTime = (double) endTime;

                /**
                 *
                 * En este if se guarda el tiempo de ejecucion de 1 hilo para luego calcular los speed-up
                 *
                 */

                if (cantThreads == 1) {

                    parallelTimeT1 = parallelTime;

                }

                /**
                 *
                 * Se calcula el Speed-up.
                 *
                 */

                double speedup = parallelTimeT1 / parallelTime;

                /**
                 *
                 * Se imprime la cantidad de threads y el tiempo empleado en cada hilo y se imprime el speed-up calculado
                 *
                 */

                System.out.println("Threads: " + cantThreads + " Time: " + parallelTime + " miliseconds, Speed-Up: " + speedup);

            }

        }

    }
}
