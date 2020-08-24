package com.eggip.temp;

import com.eggip.metapod.list.List;
import com.eggip.metapod.list.Operations;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;

import java.util.ArrayList;
import java.util.LinkedList;

public class NewListSplitMerge {

    public static List<Integer> splitMerge(List<Integer> list) {
        if (Operations.length(list) == 1) {
            return list;
        }
        Tuple3<List<Integer>, List<Integer>, List<Integer>> tuple3 = split(list, List.nil, List.nil);
        List<Integer> leftList = splitMerge(tuple3._2);
        List<Integer> rightList = splitMerge(tuple3._3);
        return merge(List.nil, leftList, rightList)._1;
    }

    private static Tuple3<List<Integer>, List<Integer>, List<Integer>> split(List<Integer> list, List<Integer> left, List<Integer> right) {
        if (list == List.nil) {
            return Tuple.of(list, left, right);
        } else {
            return split(list.tail, right, new List<>(list.head, left));
        }
    }

    private static Tuple3<List<Integer>, List<Integer>, List<Integer>> merge(List<Integer> megered, List<Integer> leftList, List<Integer> rightList) {
        if (leftList == List.nil && rightList == List.nil) {
            return Tuple.of(megered, leftList, rightList);
        } else if (leftList == List.nil) {
            return Tuple.of(Operations.append(megered, rightList), List.nil, List.nil);
        } else if (rightList == List.nil) {
            return Tuple.of(Operations.append(megered, leftList), List.nil, List.nil);
        } else {
            if (leftList.head <= rightList.head) {
                return merge(Operations.append(megered, new List<>(leftList.head, List.nil)), leftList.tail, rightList);
            } else {
                return merge(Operations.append(megered, new List<>(rightList.head, List.nil)), leftList, rightList.tail);
            }
        }
    }



    private static List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
        int i = 0, j = 0;
        List<Integer> list = new List(null, List.nil);
        while (i < Operations.length(leftList) && j < Operations.length(rightList)) {
            if (Operations.get(leftList, i) > Operations.get(rightList, j)) {
                list = Operations.add(list, Operations.get(rightList, j));
                j++;
            } else {
                list = Operations.add(list, Operations.get(leftList, i));
                i++;
            }
        }
        if (i >= Operations.length(leftList)) {
            list = Operations.addAll(list, Operations.subList(rightList, j, Operations.length(rightList)));
        }
        if (j >= Operations.length(rightList)) {
            list = Operations.addAll(list, Operations.subList(leftList, i, Operations.length(leftList)));
        }
        return list;
    }

    private static Tuple2<List<Integer>, List<Integer>> split(List<Integer> list) {
        List<Integer> leftList = Operations.subList(list, 0, Operations.length(list) / 2);
        List<Integer> rightList = Operations.subList(list, Operations.length(list) / 2, Operations.length(list));
        return new Tuple2<>(leftList, rightList);
    }

    public static void main(String[] args) {
        List<Integer> list = new List(3, new List(1, new List(2, new List(9, new List(5, List.nil)))));
        System.out.println(splitMerge(list));
    }
}
