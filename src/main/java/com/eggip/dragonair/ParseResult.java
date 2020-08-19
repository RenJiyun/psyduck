package com.eggip.dragonair;

public class ParseResult {
    private final String matched;
    private final String rest;

    public ParseResult(String matched, String rest) {
        this.matched = matched;
        this.rest = rest;
    }
}
