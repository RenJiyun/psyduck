package com.eggip.parser;

import io.vavr.Tuple2;

public class IdentityParser<T> implements Parser<T> {

    @Override
    public Tuple2<T, String> parse(String s) {
        return new Tuple2<>(null, s);
    }
    
}