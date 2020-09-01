package com.eggip.temp;

public class Demo {
    public Demo next;

    public static void main(String[] args) {
        Demo a = new Demo();
        a.next = new Demo();
        a.next = null;
    }
}
