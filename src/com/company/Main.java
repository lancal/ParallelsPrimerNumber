package com.company;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Set <Integer> data = new ConcurrentSkipListSet<>();
//        ForkJoinPool fjPool = new ForkJoinPool();
//        PrimeRecursiveAction action = new PrimeRecursiveAction(data, 0, 100000000, 2);
//        System.out.println((fjPool.invoke(action)));



        long n2=IsPrime.loopMultiThread();
        System.out.println(n2);

    }
}
