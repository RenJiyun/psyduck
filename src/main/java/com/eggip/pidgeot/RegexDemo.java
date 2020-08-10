package com.eggip.pidgeot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 参考资料：https://www.cnblogs.com/ggjucheng/p/3423731.html
public class RegexDemo {

    public static void main(String[] args) {
        System.out.println("====实验1============");
        Pattern pattern = Pattern.compile("\\d+");
        Matcher m = pattern.matcher("1234ddd1231");
        System.out.println(m.matches());    // 需匹配整个字符串
        
        System.out.println(m.lookingAt()); // 从头开始匹配
        System.out.println(m.group());

        System.out.println(m.find());
        System.out.println(m.group());   // m.start(); m.end();



        // 分组
        System.out.println("====实验2=============");
        pattern = Pattern.compile("([a-z]+)|(\\d+)");
        m = pattern.matcher("aabc1332aa12");
        System.out.println(m.groupCount());
        m.find();
        System.out.println(m.group());
        System.out.println(m.group(2));


        // 固定字符结尾
        pattern = Pattern.compile("[a-z]+:$");
        m = pattern.matcher("aaaabbb:");
        System.out.println(m.find());



        System.out.println("====实验3=============");
        // value = string | number | true | false | null | object | array;
        pattern = Pattern.compile("([a-zA-Z]+)|([0-9]+)|(true)|(false)|(null)|(\\{.*\\})|(\\[.*\\])");
        m = pattern.matcher("{\"field\":\"value\"}");
        System.out.println(m.find());
        for (int i = 1; i <= m.groupCount(); i++) {
            if (m.group(i) != null) {
                System.out.println(i + ": " + m.group(i));
            }
        }


        System.out.println("====实验4=============");
        pattern = Pattern.compile("(\"[a-zA-Z0-9]+\"):");
        m = pattern.matcher("\"field1\":\"value1\"}");
        System.out.println(m.find());
    }    
}