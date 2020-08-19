package com.eggip.dragonair;

public class ParseResult<T> {
    private final T matched;
    private final String rest;
    private final boolean success;

    private ParseResult(T matched, String rest, boolean success) {
        this.matched = matched;
        this.rest = rest;
        this.success = success;
    }

    public static <T> ParseResult<T> success(T matched, String rest) {
        return new ParseResult<>(matched, rest, true);
    }

    public static <T> ParseResult<T> error(String rest) {
        return new ParseResult<>(null, rest, false);
    }

    public T getMatched() {
        if (success) {
            return matched;
        } else {
            throw new RuntimeException();
        }
    }

    public String getRest() {
        return rest;
    }

    @Override
    public String toString() {
        return "ParseResult{" +
                "matched=" + matched +
                ", rest='" + rest + '\'' +
                ", success=" + success +
                '}';
    }
}
