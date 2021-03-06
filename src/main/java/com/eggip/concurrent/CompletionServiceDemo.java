package com.eggip.concurrent;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
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
                    Thread.sleep(1000);
                    return 0;
                }

            }));
        }
        futureList2(futureList,n);

        // while (true && futureList.size() != 0) {
        //     List<Future<Integer>> tempFutureList = new ArrayList<>();
        //     for (Future<Integer> future : futureList) {
        //         try {
        //             System.out.println(future.get(0, TimeUnit.MICROSECONDS));
        //         } catch (Throwable t) {
        //             tempFutureList.add(future);
        //         }
        //     }
        //     futureList = tempFutureList;
        // }

        // System.out.println("=======");


    }
    private static void futureList2(List<Future<Integer>> futureList,int n){
        List<Future<Integer>> futureList1=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            try {
                System.out.println(futureList.get(i).get(0, TimeUnit.MICROSECONDS));
            } catch (Throwable t) {
                futureList1.add(futureList.get(i));
                continue;
            }
        }
        if(!CollectionUtils.isEmpty(futureList1)){
            futureList2(futureList1,futureList1.size());    // java8仿佛没有尾递归优化
        }

    }
}