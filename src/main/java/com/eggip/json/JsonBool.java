package com.eggip.json;

import lombok.Getter;

@Getter
public class JsonBool implements JsonValue {
    private boolean bool;

    public JsonBool(boolean bool) {
        this.bool = bool;
    }

    @Override
    public String format() {
        return String.valueOf(bool);
    }
    
}