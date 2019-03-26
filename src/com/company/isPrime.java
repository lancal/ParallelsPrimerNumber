package com.company;

import java.util.concurrent.atomic.AtomicInteger;



public class isPrime implements Runnable {

    private static final AtomicInteger PRIME = new AtomicInteger(0) ;

    private long value;

    public isPrime(long value) {

        this.value = value;
    }

    @Override
    public void run() {

//        if(result) {
//
//            PRIME.accumulateAndGet();
//        }

        Main.isAPrimeNumber(this.value);

    }



}
