package com.eggip.temp;

import io.vavr.Tuple2;

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
        return null;
    }

    private static Tuple2<List<Integer>, List<Integer>> split(List<Integer> list) {
        return null;
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

    }
}
