package com.eggip.dragonair;

public class Parsers {

    public static Parser concat(Parser parser1, Parser parser2) {
        return new Parser() {
            @Override
            public ParseResult parse(String s) {
                ParseResult result1 = parser1.parse(s);
                ParseResult result2 = parser2.parse(result1.getRest());
                return new ParseResult(result1.getMatched() + result2.getMatched(), result2.getRest());
            }
        };
    }


    public static Parser choose(Parser parser1, Parser parser2) {
        return new Parser() {
            @Override
            public ParseResult parse(String s) {
                ParseResult result1 = parser1.parse(s);
                if (result1.getMatched() != "") {
                    return result1;
                } else {
                    ParseResult result2 = parser2.parse(result1.getRest());
                    return result2;
                }

            }
        };
    }


    public static void main(String[] args) {
        Parser parser_a = new CharParser('a');
        Parser parser_b = new CharParser('b');
        Parser parser_ab = choose(parser_a, parser_b);
        System.out.println(parser_ab.parse("barfds"));
    }
}
