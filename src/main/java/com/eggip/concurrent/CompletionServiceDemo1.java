package com.eggip.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletionServiceDemo1 {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

        int n = 10;
        for (int i = 0; i < n; i++) {
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    // 很久才返回
                    Thread.sleep(5000);
                    return 0;
                }
            });
        }



        // completionService.map(e -> doSomething(e));

        for (int i = 0; i < n; i++) {
            System.out.println(completionService.take().get());
        }

        executorService.shutdown();
    }
}