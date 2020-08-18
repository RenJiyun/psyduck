package com.eggip.parser1;

public class VoidParser implements Parser {
    @Override
    public ParseResult parse(String s) {
        return ParseResult.success(null, s);
    }
}
