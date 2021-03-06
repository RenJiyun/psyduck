package com.eggip.metapod.list;

import io.vavr.Function2;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

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
        if (list1 == List.nil) {
            return list2;
        } else {
            List<E> list3 = new List<>(list1.head, append(list1.tail, list2));
            return list3;
        }

    }

    public static <E> List<E> reverse(List<E> list) {
        if (list == List.nil) {
            return list;
        } else {
            List list2 = new List(list.head, List.nil);
            return append(reverse(list.tail), list2);
        }

    }

    public static <E> E get(List<E> list, int n) {
        if (list == List.nil && n >= 0) {
            throw new RuntimeException();
        }
        if (n == 0) {
            return list.head;
        } else {
            return get(list.tail, n - 1);
        }

    }

    public static <E> E reduce(List<E> list, E identity, Function2<E, E, E> f) {
        return null;
    }
    public static <E> List<E> subList(List<E> list,int fromIndex, int toIndex) {
        if(fromIndex>=toIndex){
            return (List<E>) List.nil;
        }
        List<E> list1=new List<>(get(list,fromIndex),subList(list, fromIndex+1, toIndex));
        return list1;

    }
    public static <E> List<E> add(List<E> list,E head) {
        if(list.head==null){
            return new List(head,List.nil);

        }else {
            Operations.getLast(list).tail=new List(head,List.nil);
            return list;
        }

    }

    private static <E> List<E> getLast(List<E> list) {
        if(length(list)==1){
            return list;
        }
        return getLast(list.tail);
    }

    public static <E>  List<E> addAll(List<E> list,List<E> subList) {
        return append(list,subList);
    }

    public static void main(String[] args) {
        List<String> list = new List("a", new List("b", new List("c",List.nil)));
      //  System.out.println(reverse(list));
     List<String> list1 = new List("a",List.nil);
//        List<String> list2 = new List("b",List.nil);
        String d="d";
        append(list,list1);
        System.out.println(list);
    }


}