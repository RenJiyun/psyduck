package com.eggip.parser1;

public class CharParser implements Parser {
    private final char c;

    public CharParser(char c) {
        this.c = c;
    }


    @Override
    public ParseResult parse(String s) {
        if (s == null || s.length() == 0) {
            return ParseResult.error("字符串不能为空", s);
        }
        if (s.charAt(0) != c) {
            return ParseResult.error("无法匹配", s);
        }

        return ParseResult.success(new Value<>(c), s.substring(1));
    }

    public static void main(String[] args) {
        CharParser charParser = new CharParser('d');
        System.out.println((charParser.parse("csd")));
    }
}
