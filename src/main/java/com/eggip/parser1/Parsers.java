package com.eggip.parser1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Parsers {

    public static final VoidParser voidParser = new VoidParser();

    public static Parser seq(Parser parser1, Parser parser2) {
        return new Parser() {
            @Override
            public ParseResult parse(String s) {
                ParseResult result1 = parser1.parse(s);
                if (result1.isSuccess()) {
                    ParseResult result2 = parser2.parse(result1.getRest());
                    return result2;
                } else {
                    return result1;
                }
            }
        };
    }


    public static Parser map(Parser parser, Function<Value<?>, Value<?>> f) {
        return new Parser() {
            @Override
            public ParseResult parse(String s) {
                ParseResult result = parser.parse(s);
                if (result.isSuccess()) {
                    return ParseResult.success(f.apply(result.getValue()), result.getRest());
                } else {
                    return result;
                }
            }
        };
    }


    public static Parser bind(Parser parser, Function<Value<?>, Parser> f) {
        return new Parser() {
            @Override
            public ParseResult parse(String s) {
                ParseResult result = parser.parse(s);
                if (!result.isSuccess()) {
                    return result;
                } else {
                    return f.apply(result.getValue()).parse(result.getRest());
                }
            }
        };
    }


    public static <T> Parser aggregate(Parser parser1, Parser parser2) {
        return null;
    }

    public static <T> Parser aggregate(Parser ... parsers) {
        return new Parser() {
            @Override
            public ParseResult parse(String s) {
                List<T> values = new ArrayList<>();
                ParseResult<T> result = null;
                for (Parser parser : parsers) {
                    result = parser.parse(s);
                    if (result.isSuccess()) {
                        values.add(result.getValue().getT());
                        s = result.getRest();
                    } else {
                        return result;
                    }
                }

                return ParseResult.success(new Value<>(values), result.getRest());

            }
        };
    }


    public static Parser seq(Parser ...parsers) {
        if (parsers == null || parsers.length == 0) {
            return voidParser;
        }
        return Arrays.stream(parsers).reduce(voidParser, Parsers::seq);
    }


    public static Parser str(String s) {
        if (s == null || s.length() == 0) {
            return voidParser;
        }
        return aggregate(toChars(s).stream().map(CharParser::new).collect(Collectors.toList()).toArray(new CharParser[0]));
    }


    private static List<Character> toChars(String s) {
        List<Character> characters = new ArrayList<>();
        for (char c : s.toCharArray()) {
            characters.add(c);
        }

        return characters;
    }



    public static void main(String[] args) {
        Parser parser = str("abc");
        System.out.println(parser.parse("abcdef"));
    }

}
