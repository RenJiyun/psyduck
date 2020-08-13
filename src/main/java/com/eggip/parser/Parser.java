package com.eggip.parser;

import io.vavr.Function1;
import io.vavr.Tuple2;
import io.vavr.control.Either;

@FunctionalInterface
public interface Parser<T> {
    public static final IdentityParser identity = new IdentityParser();
    public static final NullParser nil = new NullParser();

    Tuple2<T, String> parse(String s);

    default <R> Parser<Tuple2<T, R>> concat(Parser<R> p) {
        return Parsers.concat(this, p);
    }

    default <R> Parser<Either<T, R>> orElse(Parser<R> p) {
        return Parsers.orElse(this, p);
    }

    default <R> Parser<R> map(Function1<T, R> f) {
        return Parsers.map(this, f);
    }
}