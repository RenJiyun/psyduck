package com.eggip.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        /**
         * {
         *   "field1": 1.2,
         *   "field2": "hello",
         *   "field3": { "d": 1 },
         *   "field4": [],
         *   "field5": false
         * }
         */
        
        Map<String, JsonValue> map = new HashMap<>();
        map.put("field1", new JsonNum(1.2));
        map.put("field2", new JsonStr("hello"));

        Map<String, JsonValue> map1 = new HashMap<>();
        map1.put("d", new JsonNum(1));
        map.put("field3", new JsonObject(map1));

        map.put("field4", new JsonArray(new ArrayList<>()));
        map.put("field5", new JsonBool(false));
        JsonObject jsonObject = new JsonObject(map);

        System.out.println(jsonObject);

         

    }
}