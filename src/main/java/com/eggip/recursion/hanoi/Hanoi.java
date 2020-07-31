package com.eggip.recursion.hanoi;

import java.util.Arrays;

public class Hanoi {

    public static void solve(int m, String source, String target, String middle) {
        if (m == 1) {
            System.out.println(String.format("%s -> %s", source, target));
        } else {
            solve(m - 1, source, middle, target);
            solve(1, source, target, middle);
            solve(m - 1, middle, target, source);
        }
    }


    public static int sum(int[] intArray) {
        if (intArray == null || intArray.length == 0) return 0;
        return intArray[0] + sum(Arrays.copyOfRange(intArray, 1, intArray.length));
    }

    public static int max(int[] intArray) {
        // [1, 2, 3, 4, 5]  1 [2, 3, 4, 5]
        // 数组的最大值 = 数组的头部 > max(数组尾巴) ? 数组头部 ：max(数组尾巴)
        if (intArray == null || intArray.length == 0) {
            System.out.println("数组为空");
            throw new RuntimeException("-----");
        } 
 
        if (intArray.length == 1) {
            return intArray[0];
        }

        int[] tail = Arrays.copyOfRange(intArray, 1, intArray.length);
        int tailMax = max(tail);

        return intArray[0] > tailMax
                            ? intArray[0] 
                            : tailMax;
    }



    public static void main(String[] args) {
        int[] intArray = {1, 2, 3};
        System.out.println(max(intArray));
    }
    
}