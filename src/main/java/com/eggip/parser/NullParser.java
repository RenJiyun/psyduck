package com.eggip.parser;

import io.vavr.Tuple2;

public class NullParser<T> implements Parser<T> {

    @Override
    public Tuple2<T, String> parse(String s) {
        throw new ParseException();
    }

}