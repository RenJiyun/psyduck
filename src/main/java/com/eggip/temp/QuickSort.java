package com.eggip.temp;


import io.vavr.Tuple2;
import io.vavr.Tuple3;

import java.util.ArrayList;
import java.util.List;

/**
 * 快排
 */
public class QuickSort {
    public static List<Integer> quickSortV1(List<Integer> list) {
        if (list.size() == 1 || list.size() == 0) {
            return list;
        } else {
            Tuple3<List<Integer>, Integer, List<Integer>> tuple3 = partition(list);
            List<Integer> leftList = quickSortV1(tuple3._1);
            Integer pivot = tuple3._2;
            List<Integer> rightList = quickSortV1(tuple3._3);
            return merge(leftList, pivot, rightList);
        }
    }

    private static Tuple3<List<Integer>, Integer, List<Integer>> partition(List<Integer> list) {
        Integer pivot = list.get(0);
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (pivot >= list.get(i)) {
                leftList.add(list.get(i));
            } else {
                rightList.add(list.get(i));
            }
        }
        return new Tuple3<>(leftList, pivot, rightList);
    }

    public static List<Integer> merge(List<Integer> leftList, Integer pivot, List<Integer> rightList) {
        List<Integer> list = new ArrayList<>();
        list.addAll(leftList);
        list.add(pivot);
        list.addAll(rightList);
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(7);
        list.add(3);
        list.add(1);
        List<Integer> list1 = quickSortV1(list);
        System.out.println(list1);

    }

}
