package com.eggip.lock;

public class Demo1 {
    
    public static Demo2 demo2;

    public synchronized void m1() {
        System.out.println("m1");
    }

    public synchronized void m2() {
        System.out.println("m2");
    }


    public void m3(int a, int b, Demo3 demo3) {
        int c;
        int d;
        demo3.doSomething();
    }



    public static void main(String[] args) {

        Demo1 demo1 = new Demo1();

        Demo3 demo3 = new Demo3();

        demo1.m3(1, 1, demo3);  // 1

        demo3.doSomething();   // 2




        Demo1 demo2 = new Demo1();
        
        new Thread(new Runnable(){
            @Override
            public void run() {
                demo1.m1();
            }
        }).start();


        new Thread(new Runnable() {

            @Override
            public void run() {
                demo1.m1();
            }

        }).start();
        
    }
    
}