package com.polyg7ot.java.msb.bootcamp.multithreading.keyword_synchronize.T03AtomicInteger;

public class App {
    public static void main(String[] args) throws InterruptedException{
        DemoAtomicInteger demoAtomicInteger = new DemoAtomicInteger();
        // expected to 10000000
        System.out.println("Atomic Integer");
        System.out.println(demoAtomicInteger.applyAtomicInteger());

        DemoRegularInteger demoRegularInteger = new DemoRegularInteger();
        System.out.println("Regular Integer without keyword Synchronize");
        System.out.println(demoRegularInteger.regluarIntegerWithoutKeywordSynchronize());
        System.out.println("Regular Integer with keyword Synchronize");
        System.out.println(demoRegularInteger.regluarIntegerWithKeywordSynchronize());
    }
}