package com.eggip.lock;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Demo2 {
    public static Demo3 demo3;

    private static Executor executor = Executors.newFixedThreadPool(10);

    private Runnable task;

    // a + b = 100
    private int a;
    private int b;

    private Demo2() {
        task = new Runnable() {
            @Override
            public void run() {
                doSomething();
            }
        };
        a = 10;
        b = 90;
        
    }

    public static Demo2 newInstance() {
        Demo2 demo = new Demo2();
        executor.execute(demo.task);
        return demo;
    }

    private void doSomething() {
        System.out.println("a + b should be " +  (a + b));
    }


    public static void main(String[] args) throws InterruptedException {
        newInstance();
    }
    
}