package com.eggip.dragonair;

public class CharParser implements Parser<Character> {

    private final char c;

    public CharParser(char c) {
        this.c = c;
    }

    @Override
    public ParseResult<Character> parse(String s) {
        if (s == null || s.length() == 0 || s.toCharArray()[0] != c) {
            return new ParseResult("", s);
        } else {
            return new ParseResult(String.valueOf(c), s.substring(1));
        }
    }


    public static void main(String[] args) {
        Parser parser = new CharParser('c');
        System.out.println((parser.parse("")));
    }


}
