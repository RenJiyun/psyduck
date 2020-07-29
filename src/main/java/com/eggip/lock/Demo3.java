package com.eggip.lock;

public class Demo3 {

    // a + b = 100
    private int a;
    private int b;

    public Demo3() {
        doSomething();

        a = 10;
        b = 90;
    }

    public void doSomething() {
    }

    public static class Demo3Child extends Demo3 {
        
        @Override
        public void doSomething() {
            System.out.println("======");
            Demo2.demo3 = this;
        }
    }


    public static void main(String[] args) {
        new Demo3Child();
    }
    
}