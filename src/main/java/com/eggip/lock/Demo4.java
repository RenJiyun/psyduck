package com.eggip.lock;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Demo4 {
    private static Executor executor = Executors.newFixedThreadPool(3);
    private final ThreadLocal<Integer> a =
         new ThreadLocal<Integer>() {
             @Override protected Integer initialValue() {
                 System.out.println("--------");
                 return 0;
         }
     };


    public void hello() {
        System.out.println(a);
        Integer i = a.get();
        i++;
        a.set(i);
        System.out.println(a.get());
    }


    public static void main(String[] args) {
        Demo4 demo = new Demo4();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                demo.hello();
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                demo.hello();
            }
        });
        
    }
    
}