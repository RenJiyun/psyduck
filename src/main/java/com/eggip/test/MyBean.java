package com.eggip.test;

import java.net.Socket;

public class MyBean {
    public static String socket;

    public static void main(String[] args) {
        int a=1;
        setValue1(a);
        System.out.println(a);
        String s1 = "rr";
        setValue(s1);
        System.out.println(s1);
        MyBean myBean1 = new MyBean();
        myBean1.socket = "aa";
        getBean(myBean1);
        System.out.println(myBean1.socket);
    }

    private static String  setValue(String s2) {
       return s2 = "ttt";
    }
    private static int setValue1(int s2) {
        s2 = 3;
        return s2;
    }

    public static void getBean(MyBean myBean) {
        myBean.socket = "def";
    }
}
