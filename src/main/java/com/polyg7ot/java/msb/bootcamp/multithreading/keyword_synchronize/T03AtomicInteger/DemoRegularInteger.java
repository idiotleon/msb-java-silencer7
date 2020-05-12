package com.polyg7ot.java.msb.bootcamp.multithreading.keyword_synchronize.T03AtomicInteger;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class DemoRegularInteger {
    private Integer m = new Integer(0);
    public int regluarIntegerWithoutKeywordSynchronize() throws InterruptedException{
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(() -> {
                for(int j = 0; j < 10000; j++){
                    m++;
                }

                latch.countDown();
            });
        }

        Arrays.stream(threads).forEach((t) -> t.start());

        latch.await();

        return m;
    }

    private Integer n = new Integer(0);
    public int regluarIntegerWithKeywordSynchronize() throws InterruptedException{
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(() -> {
                for(int j = 0; j < 10000; j++){
                    synchronized(this){
                        n++;
                    }
                }

                latch.countDown();
            });
        }

        Arrays.stream(threads).forEach((t) -> t.start());

        latch.await();

        return n;
    }
}