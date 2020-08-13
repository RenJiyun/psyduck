package com.eggip.parser;

import io.vavr.Tuple2;

public class CharParser implements Parser<Character> {
    private char c;

    public CharParser(char c) {
        this.c = c;
    }

    @Override
    public Tuple2<Character, String> parse(String s) {
        if (s == null || s.length() == 0) {
            throw new RuntimeException();
        }

        if (s.charAt(0) != c) {
            throw new RuntimeException();
        }

        return new Tuple2<>(c, s.substring(1));
    }

    
    
}