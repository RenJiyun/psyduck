package com.eggip.squirtle;

public class Bar {
    private Foo foo;

    public Bar(Foo foo) {
        this.foo = foo;
    }

    public void greet() {
        foo.greet(this);
    }

}