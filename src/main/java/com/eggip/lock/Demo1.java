package com.eggip.lock;

public class Demo1 {

    public synchronized void m1() {
        System.out.println("m1");
    }

    public synchronized void m2() {
        System.out.println("m2");
    }



    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
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