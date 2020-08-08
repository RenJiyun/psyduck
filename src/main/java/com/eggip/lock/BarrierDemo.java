package com.eggip.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import org.apache.tomcat.util.threads.LimitLatch;

public class BarrierDemo {

    private static CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println("跑完一轮了！！！！");

        }
    });

    private static CountDownLatch latch = new CountDownLatch(1);

    private static class Horse implements Runnable {
        private volatile int id;

        public Horse(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    latch.await();
                    Thread.sleep(2000);  // 跑的时间
                    System.out.println(String.format("马%s跑到终点了", id));
                    barrier.await();
                } catch (Throwable t) {

                }

            }

        }

    }


    public static void main(String[] args)  {
        for (int i = 0; i < 3; i++) {
            new Thread(new Horse(i)).start();
        }

        try {
            Thread.sleep(10000);
        } catch (Throwable t) {

        }
        
        System.out.println("跑起来！！！！");

        latch.countDown();
    }

}