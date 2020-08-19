package com.eggip.pikachu;

import java.util.stream.IntStream;

public class StreamDemo {
    public static void main(String[] args){
         System.out.println(IntStream.range(0, 100).reduce(0, (e1,e2)->e1+e2));

    }
}
