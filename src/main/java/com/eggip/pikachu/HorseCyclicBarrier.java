package com.eggip.pikachu;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

/**
 * 服务名称/类名称/类基本概念/类职责栅栏
 *
 * @author chenqingning
 * @date 2020-08-11 22:57
 */
public class HorseCyclicBarrier {
    private static CyclicBarrier cyclicBarrier =new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println("马儿已经跑了一圈了");
        }
    });
    public static class HorseRace implements  Runnable{
      private volatile int id;
      public HorseRace(int id){
          this.id=id;
      }
        @Override
        public void run() {
            while(true) {

            try {
                Thread.sleep(2000);  // 跑的时间
                System.out.println("马儿"+id+"号跑到终点了");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }


        }
    }
    public  static void main(String[] args) throws BrokenBarrierException, InterruptedException {
              for ( int i=0;i<3;i++){
                  HorseRace horseRace=new HorseRace(i);
                  Executors.newFixedThreadPool(1).execute(horseRace);
              }
    }
}
