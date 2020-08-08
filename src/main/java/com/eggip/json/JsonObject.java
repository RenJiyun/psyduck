package com.eggip.json;

import java.util.Map;

import lombok.Getter;

@Getter
public class JsonObject implements JsonValue {
    private Map<String, JsonValue> map;

    public JsonObject(Map<String, JsonValue> map) {
        this.map = map;
    }
    

    @Override
    public String format() {
        String temp = "";
        for (String key : map.keySet()) {
            temp = temp + "\"" + key + "\"" + ":" + map.get(key).format() + ",";
        }

        temp = temp.substring(0, temp.length() - 1);
        return "{" + temp + "}";
    }


    @Override
    public String toString() {
        return format();
    }

}