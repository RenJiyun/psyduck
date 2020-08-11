package com.eggip.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Demo1 {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(1);
    public static void main(String[] args) throws InterruptedException {
        Future<String> future = executorService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {

                while (true) {
                    System.out.println(Thread.currentThread().isInterrupted());
                }
			}
        });

        Thread.sleep(3000);
        future.cancel(true);

    }
}