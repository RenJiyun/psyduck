package com.eggip.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.vavr.Function1;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Either;

public class Parsers {

    public static <T, R> Parser<Tuple2<T, R>> concat(Parser<T> p1, Parser<R> p2) {
        return new Parser<Tuple2<T, R>>() {

            @Override
            public Tuple2<Tuple2<T, R>, String> parse(String s) {
                Tuple2<T, String> p1Result = p1.parse(s);
                Tuple2<R, String> p2Result = p2.parse(p1Result._2);
                return new Tuple2<>(new Tuple2<>(p1Result._1, p2Result._1), p2Result._2);
            }
        };
    }

    public static <T, R> Parser<Either<T, R>> orElse(Parser<T> p1, Parser<R> p2) {
        return new Parser<Either<T, R>>() {

            @Override
            public Tuple2<Either<T, R>, String> parse(String s) {
                try {
                    Tuple2<T, String> p1Result = p1.parse(s);
                    return Tuple.of(Either.left(p1Result._1), p1Result._2);
                } catch (RuntimeException e) {
                    Tuple2<R, String> p2Result = p2.parse(s);
                    return Tuple.of(Either.right(p2Result._1), p2Result._2);
                }
            }

        };
    }

    public static <T, R> Parser<R> map(Parser<T> p, Function1<T, R> f) {
        return new Parser<R>() {

            @Override
            public Tuple2<R, String> parse(String s) {
                Tuple2<T, String> pResult = p.parse(s);
                return Tuple.of(f.apply(pResult._1), pResult._2);
            }

        };
    }

    public static Parser<?> any(List<Parser<?>> parsers) {
        return parsers.stream().reduce(Parser.nil, Parsers::orElse);
    }

    public static Parser<?> any(Parser<?>... parsers) {
        return any(Arrays.asList(parsers));
    }

    public static Parser<?> all(List<Parser<?>> parsers) {
        return parsers.stream().reduce(Parser.identity, Parsers::concat);
    }

    public static Parser<?> zeroOrOne(Parser<?> parser) {
        return orElse(parser, Parser.identity);
    }

    public static Parser<?> many(Parser<?> parser, int n) {
        List<Parser<?>> parsers = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            parsers.add(parser);
        }

        return all(parsers);
    }

    @SuppressWarnings("unchecked")
    public static <T> Parser<?> many(Parser<T> parser) {
        Parser<Parser<Object>> tempParser = new Parser<Parser<Object>>() {

            @Override
            public Tuple2<Parser<Object>, String> parse(String s) {
                Parser<?> result = parser;
                while (true) {
                    try {
                        result.parse(s);
                        result = result.concat(parser);
                    } catch (RuntimeException e) {
                        
                    }
                }
            }

        };

        return s -> tempParser.parse(s)._1.parse(s);
    }

    public static void main(String[] args) {
        Parser<?> parser = many(new CharParser('c'), 2);
        System.out.println(parser.parse("ccredf"));
    }

}