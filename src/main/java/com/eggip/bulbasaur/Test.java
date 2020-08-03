package com.eggip.bulbasaur;

public class Test {

    public static void main(String[] args) {
        // 2 + 3 * 4
        Expr expr = new Add(new Number(2), new Multiply(new Number(3), new Number(4)));
        System.out.println(expr.reduce().getValue());
    }
    
}