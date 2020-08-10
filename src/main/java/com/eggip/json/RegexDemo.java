package com.eggip.json;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexDemo {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("([a-z]+)([0-9]+)");
        Matcher m = pattern.matcher("abc121eftg34352");
        System.out.println(m.find());
        System.out.println(m.group(0));
        System.out.println(m.group(1));
        System.out.println(m.group(2));

        System.out.println(m.find());
        System.out.println(m.group(0));
        System.out.println(m.group(1));
        System.out.println(m.group(2));
        
    }
    
}