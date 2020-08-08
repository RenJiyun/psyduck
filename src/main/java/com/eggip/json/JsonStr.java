package com.eggip.json;

import lombok.Getter;

@Getter
public class JsonStr implements JsonValue {
    private String str;

    public JsonStr(String str) {
        this.str = str;
    }

    @Override
    public String format() {
        return "\"" + str + "\"";
    }

    
}