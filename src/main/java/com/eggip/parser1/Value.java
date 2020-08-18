package com.eggip.parser1;

public class Value<T> {

    private T t;

    public Value(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    @Override
    public String toString() {
        return "Value{" +
                "t=" + t +
                '}';
    }
}
