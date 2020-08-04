package com.eggip.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Hello {

    private int a;
    private int b;

    private Object obj = new Object();

    private static ConcurrentHashMap<String, Object> safeMap = new ConcurrentHashMap<>();

    public Hello(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void f() {
        synchronized(obj) {

        }
    }


    public static void main(String[] args) {
        Hello hello = new Hello(1, 2);

        synchronized(hello) {
            // 
            while (true) {

            }
        }


        hello.f();
        

    }

    

    
}