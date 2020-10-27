package com.eggip.test;

import java.net.Socket;

public class MyBean {
    public  String socket;
    public static int a1;
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


        System.out.println("as" == "as");

        String ss1 = "as";
        String ss2 = "as";
        System.out.println(ss1 == ss2);

        String ss3 = new String("as");
        String ss4 = new String("as");
        System.out.println(ss3 == ss4);
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
