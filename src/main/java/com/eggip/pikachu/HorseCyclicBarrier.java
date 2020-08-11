package com.eggip.pikachu;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 服务名称/类名称/类基本概念/类职责栅栏
 *
 * @author chenqingning
 * @date 2020-08-11 22:57
 */
public class HorseCyclicBarrier {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId() + "============");
            System.out.println("马儿已经跑了一圈了");
        }
    });

    public static class HorseRace implements Runnable {
        private volatile int id;

        public HorseRace(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000); // 跑的时间
                    System.out.println("马儿" + id + "号跑到终点了");
                    System.out.println(Thread.currentThread().getId());
                    cyclicBarrier.await();
                } catch (Throwable t) {}
            }

        }
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Executor executor = Executors.newFixedThreadPool(3);
        System.out.println(Thread.currentThread().getId() + "主线程");
        for (int i = 0; i < 3; i++) {
            HorseRace horseRace = new HorseRace(i);
            executor.execute(horseRace);
        }
    }
}
