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


    public static Parser str(String s) {
        return new Parser() {
            @Override
            public ParseResult parse(String s1) {
                ParseResult result = new ParseResult("", s1);
                for (int i = 0; i < s.length(); i++) {
                    if (i + 1 < s.length()) {
                        Parser parser = concat(new CharParser(s.charAt(i)), new CharParser(s.charAt(i + 1)));
                        ParseResult  result2 = parser.parse(result.getRest());
                        result=new ParseResult(result.getMatched()+result2.getMatched(), result2.getRest());

                    } else {
                        ParseResult result1 =new CharParser(s.charAt(i)).parse(result.getRest());
                        result=new ParseResult(result.getMatched()+result1.getMatched(),result1.getRest());
                    }
                }
                return  result;
            }
        };
    }


    public static void main(String[] args) {
        Parser parser = str("hellod");
        System.out.println(parser.parse("hellodfads"));
    }
}
