package com.eggip.dragonair;

public interface Parser<T> {

    /**
     * @param s 待解析的字符串
     * @return 解析完之后剩下的字符串
     */
    ParseResult<T> parse(String s);
}
