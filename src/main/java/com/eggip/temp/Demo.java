package com.eggip.temp;

import javax.crypto.spec.PSource;

public class Demo {

    private static int[] cost = {2, 3, 7, 4, 5, 8, 10};

    public static int f(int n) {
        if (n < 2 || n > cost.length ) {
            throw new IllegalArgumentException();
        }

        return g(n);

    }

    public static int g(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return Integer.min(cost[0], cost[1]);
        } else {
            return Integer.min(g(n - 1) + cost[n - 1], g(n - 2) + cost[n - 2]);
        }
    }

    public static void main(String[] args) {

    }
}
