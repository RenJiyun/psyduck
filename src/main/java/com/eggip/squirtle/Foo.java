package com.eggip.squirtle;

public class Foo {
    private String greeting;

    public Foo(String greeting) {
        this.greeting = greeting;
    }


    public void greet(Object obj) {
        System.out.println(String.format("%s, %s", greeting, obj));
    }
    
    
}