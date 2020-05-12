package com.polyg7ot.java.msb.bootcamp.multithreading.keyword_synchronize.T03AtomicInteger;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoAtomicInteger {
    public AtomicInteger applyAtomicInteger() throws InterruptedException{
        AtomicInteger m = new AtomicInteger(0);
        Thread[] threads = new Thread[100];

        CountDownLatch latch = new CountDownLatch(threads.length);

        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(() -> {
                for(int j = 0; j < 100000; j++){
                    m.incrementAndGet();
                }

                latch.countDown();
            });
        }

        Arrays.stream(threads).forEach((t) -> t.start());

        latch.await();

        return m;
    }
}