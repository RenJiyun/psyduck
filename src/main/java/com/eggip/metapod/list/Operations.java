package com.eggip.metapod.list;

import io.vavr.Function2;

public class Operations {


    public static <E> int length(List<E> list) {
        if (list == List.nil) return 0;
        else return 1 + length(list.tail);
    }


    // 尾递归版本，将对结果的操作交给被调用的函数
    public static <E> int length_tail(List<E> list, int n) {
        if (list == List.nil) return n;
        else return length_tail(list.tail, n + 1);
    }

    public static <E> List<E> append(List<E> list1, List<E> list2) {
        return null;
    }

    public static <E> List<E> reverse(List<E> list) {
        return null;
    }

    public static <E> E get(List<E> list, int n) {
        return null;
    }

    public static <E> E reduce(List<E> list, E identity, Function2<E, E, E> f) {
        return null;
    }


    public static void main(String[] args) {
        List<String> list = new List("a", new List("b", List.nil));
        System.out.println(length_tail(list, 0));
    }
    
}