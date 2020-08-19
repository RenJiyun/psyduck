package com.eggip.dragonair;

public class Parsers {

    public static Parser concat(Parser parser1, Parser parser2) {
        return null;
    }


    public static void main(String[] args) {
        Parser parser_a = new CharParser('a');
        Parser parser_b = new CharParser('b');
        Parser parser_ab = concat(parser_a, parser_b);
    }
}
