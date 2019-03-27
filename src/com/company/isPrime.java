package com.company;

//import java.util.concurrent.atomic.AtomicInteger;

public class isPrime implements Runnable {

    //private static final AtomicInteger PRIME = new AtomicInteger(0) ;

    /**
     *
     * Se declara e inicializa la variable value.
     *
     */

    private long value = 0;

    /**
     *
     * Metodo para guardar un numero, en este caso primo.
     *
     * @param value
     */

    public isPrime(long value) {

        this.value = value;
    }

    /**
     *
     * Ejecucion de la funcion Main para encontrar si un numero es primo.
     *
     */

    @Override
    public void run() {

        Main.isAPrimeNumber(this.value);

    }



}
