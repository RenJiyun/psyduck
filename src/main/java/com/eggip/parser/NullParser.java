package com.eggip.parser;

import io.vavr.Tuple2;

public class NullParser implements Parser<Void> {

    @Override
    public Tuple2<Void, String> parse(String s) {
        throw new RuntimeException();
    }
    
}