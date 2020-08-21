package com.eggip.temp;

import io.vavr.Tuple2;

import java.util.ArrayList;
import java.util.List;


public class SplitMerge {

    public static List<Integer> splitAndMergeV1(List<Integer> list) {
        if (list.size() > 1) {
            Tuple2<List<Integer>, List<Integer>> splitResult = split(list);
            List<Integer> left = splitAndMergeV1(splitResult._1);
            List<Integer> right = splitAndMergeV1(splitResult._2);
            return merge(left, right);
        } else {
            return list;
        }
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                list.add(left.get(i));
                i++;
            } else {
                list.add(right.get(j));
                j++;
            }
        }
        if (i >= left.size()) {
                list.addAll(right.subList(j, right.size()));
        }
        if (j >= right.size()) {
                list.addAll(left.subList(i,left.size()));

        }
        return list;
    }

    private static Tuple2<List<Integer>, List<Integer>> split(List<Integer> list) {
        Tuple2<List<Integer>, List<Integer>> tuple2 = new Tuple2<>(list.subList(0, list.size() / 2), list.subList(list.size() / 2, list.size()));
        return tuple2;
    }


    public static void splitAndMergeV2(List<Integer> list, int start, int end) {
        if (end - start == 1) {
            return;
        } else {
            int middle = (start + end) / 2;
            splitAndMergeV2(list, start, middle);
            splitAndMergeV2(list, middle, end);
            merge(list, start, middle, end);
        }
    }

    private static void merge(List<Integer> list, int start, int middle, int end) {
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(7);
        list.add(3);
        list.add(1);
        List<Integer> list1=splitAndMergeV1(list);
        System.out.println(list1);

    }
}
