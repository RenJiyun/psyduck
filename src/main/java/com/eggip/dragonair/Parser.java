package com.eggip.dragonair;

public interface Parser {

    /**
     * @param s 待解析的字符串
     * @return 解析完之后剩下的字符串
     */
    ParseResult parse(String s);
}
