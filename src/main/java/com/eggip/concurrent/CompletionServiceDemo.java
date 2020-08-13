package com.eggip.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CompletionServiceDemo {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        int n = 10;
        List<Future<Integer>> futureList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            futureList.add(executorService.submit(new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    // 很久才返回
                    Thread.sleep(3000);
                    return 0;
                }

            }));
        }


        for (int i = 0; i < n; i++) {
            try {
                System.out.println(futureList.get(i).get(0, TimeUnit.MICROSECONDS));
            } catch (Throwable t) {
                t.printStackTrace();
                continue;
            }
        }
    }
}