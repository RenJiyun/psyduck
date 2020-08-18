package com.eggip.parser1;

public class ParseResult<T> {

    private final boolean status;
    private final String errorMsg;
    private final Value<T> value;
    private final String rest;


    private ParseResult(boolean status, String errorMsg, String rest) {
        this.status = status;
        this.errorMsg = errorMsg;
        this.value = null;
        this.rest = rest;
    }

    private ParseResult(boolean status, Value<T> value, String rest) {
        this.status = status;
        this.errorMsg = null;
        this.value = value;
        this.rest = rest;
    }


    public boolean isSuccess() {
        return this.status;
    }

    public String getRest() {
        return this.rest;
    }

    public Value<T> getValue() {
        return this.value;
    }

    public static ParseResult error(String errorMsg, String rest) {
        return new ParseResult(false, errorMsg, rest);
    }

    public static ParseResult success(Value<?> value, String rest) {
        return new ParseResult(true, value, rest);
    }


    @Override
    public String toString() {
        return "ParseResult{" +
                "status=" + status +
                ", errorMsg='" + errorMsg + '\'' +
                ", value=" + value +
                ", rest='" + rest + '\'' +
                '}';
    }
}
