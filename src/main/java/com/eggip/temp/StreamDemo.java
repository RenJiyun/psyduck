package com.eggip.temp;

import java.util.Spliterator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        String a = IntStream.range(1, 100).mapToObj(e -> Integer.valueOf(e)).parallel().reduce("", (a1, a2) -> a1 + "," + a2, (e1, e2) -> e1 +  e2);
        System.out.println(a);

    }
}
