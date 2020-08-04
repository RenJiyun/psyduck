package com.eggip.ivysaur;


public class JBool implements JValue {

    private boolean bool;

    @Override
    public String toJson() {
        if (bool) {
            return "true";
        } else {
            return "false";
        }
    }
    
}