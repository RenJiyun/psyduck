package com.eggip.json;

import java.util.List;

import lombok.Getter;

@Getter
public class JsonArray implements JsonValue {
    private List<JsonObject> list;

    public JsonArray(List<JsonObject> list) {
        this.list = list;
    }

    @Override
    public String format() {
        String temp = "";
        for (JsonObject jsonObject : list) {
            temp = temp + jsonObject.format() + ",";
        }
        if (temp.length() > 0) {
            temp = temp.substring(0, temp.length() - 1);
        }
        return "[" + temp + "]";
    }
    
    
}