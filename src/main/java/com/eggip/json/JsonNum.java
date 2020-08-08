package com.eggip.json;

import lombok.Getter;

@Getter
public class JsonNum implements JsonValue {
    private Number num;

    public JsonNum(Number num) {
        this.num = num;
    }

    @Override
    public String format() {
        return num.toString();
    }

}