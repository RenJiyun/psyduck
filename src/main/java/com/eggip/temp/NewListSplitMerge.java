package com.eggip.temp;

import com.eggip.metapod.list.List;
import com.eggip.metapod.list.Operations;
import io.vavr.Tuple2;

import java.util.ArrayList;
import java.util.LinkedList;

public class NewListSplitMerge {

    public static List<Integer> splitMerge(List<Integer> list) {
        if (Operations.length(list) == 1) {
            return list;
        }
        Tuple2<List<Integer>, List<Integer>> tuple2 = split(list);
        List<Integer> leftList = splitMerge(tuple2._1);
        List<Integer> rightList = splitMerge(tuple2._2);
        return merge(leftList, rightList);
    }

    private static List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
        int i = 0, j = 0;
        List<Integer> list=new List(null,List.nil);
        while (i < Operations.length(leftList) && j < Operations.length(rightList)) {
            if (Operations.get(leftList,i) > Operations.get(rightList,j)) {
                list=Operations.add(list,Operations.get(rightList,j));
                j++;
            }else {
                list=Operations.add(list,Operations.get(leftList,i));
                i++;
            }
        }
        if(i >= Operations.length(leftList) ){
            list=Operations.addAll(list,Operations.subList(rightList,j,Operations.length(rightList)));
        }
        if(j >= Operations.length(rightList) ){
            list=Operations.addAll(list,Operations.subList(leftList,i,Operations.length(leftList)));
        }
        return list;
    }

    private static Tuple2<List<Integer>, List<Integer>> split(List<Integer> list) {
        List<Integer> leftList = Operations.subList(list, 0, Operations.length(list) / 2);
        List<Integer> rightList = Operations.subList(list, Operations.length(list) / 2, Operations.length(list));
        return new Tuple2<>(leftList, rightList);
    }

    public static void main(String[] args) {
        List<Integer> list = new List(3, new List(1, new List(2, new List(9, new List(5,List.nil)))));
        System.out.println(splitMerge(list));

    }
}
