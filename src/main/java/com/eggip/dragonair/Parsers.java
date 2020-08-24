//package com.eggip.dragonair;
//
//import java.util.function.Function;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
//public class Parsers {
//
//    public static final Parser identity = new Parser() {
//        @Override
//        public ParseResult parse(String s) {
//            return new ParseResult("", s);
//            return  null;
//        }
//
//    };
//
//
//    public static Parser concat(Parser parser1, Parser parser2) {
//        return new Parser() {
//                    @Override
//                    public ParseResult parse(String s) {
//                        ParseResult result1 = parser1.parse(s);
//                        ParseResult result2 = parser2.parse(result1.getRest());
//                        return new ParseResult(result1.getMatched() + result2.getMatched(), result2.getRest());
//            }
//        };
//    }
//
//    public static Parser choose(Parser parser1, Parser parser2) {
//        return new Parser() {
//            @Override
//            public ParseResult parse(String s) {
//                ParseResult result1 = parser1.parse(s);
//                if (result1.getMatched() != "") {
//                    return result1;
//                } else {
//                    ParseResult result2 = parser2.parse(result1.getRest());
//                    return result2;
//                }
//
//            }
//        };
//    }
//
//
//    public static Parser strV2(String s) {
//        return IntStream.range(0, s.length()).mapToObj(s::charAt).map(c -> (Parser) new CharParser(c)).reduce(identity, Parsers::concat);
//    }
//
//
//    public static Parser choose(String s) {
//        return IntStream.range(0, s.length()).mapToObj(s::charAt).map(c -> (Parser) new CharParser(c)).reduce(identity, Parsers::choose);
//    }
//
//
//    public static Parser strV1(String s) {
//        return new Parser() {
//            @Override
//            public ParseResult parse(String s1) {
//                ParseResult result = new ParseResult("", s1);
//                for (int i = 0; i < s.length(); i++) {
//                    if (i + 1 < s.length()) {
//                        Parser parser = concat(new CharParser(s.charAt(i)), new CharParser(s.charAt(i + 1)));
//                        ParseResult result2 = parser.parse(result.getRest());
//                        result = new ParseResult(result.getMatched() + result2.getMatched(), result2.getRest());
//
//                    } else {
//                        ParseResult result1 = new CharParser(s.charAt(i)).parse(result.getRest());
//                        result = new ParseResult(result.getMatched() + result1.getMatched(), result1.getRest());
//                    }
//                }
//                return result;
//            }
//        };
//    }
//
//
//    public static <T, U> Parser<U> map(Parser<T> parser, Function<T, U> f) {
//        return new Parser() {
//            @Override
//            public ParseResult<U> parse(String s) {
//                ParseResult<T> result = parser.parse(s);
//                if (result.getMatched().equals("")) {
//                    return ParseResult.error(s);
//                } else {
//                    return ParseResult.success(f.apply(result.getMatched()), result.getRest());
//                }
//            }
//        };
//    }
//
//
//    public static void main(String[] args) {
//        Parser parser = map(strV2("true"), s -> Boolean.valueOf(s));
//        System.out.println(parser.parse("truedafgdsa").getMatched() || false);
//    }
//}
