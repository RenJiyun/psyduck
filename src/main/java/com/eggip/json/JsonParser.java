package com.eggip.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {
    private static final Pattern keyPattern = Pattern.compile("(\"[a-zA-Z0-9]+\")");
    private static final Pattern valuePattern = 
        Pattern.compile("(\"[a-zA-Z0-9]+\")|([0-9]+)|(true)|(false)|(null)|(\\{.*\\})|(\\[.*\\])");

    private String jsonString;

    private int pos;
    
    public JsonParser(String jsonString) {
        this.jsonString = jsonString;
        this.pos = 0;
    }


    public JsonValue parse() {
        if (peek().equals("{")) {
            return parseObject();
        } else if (peek().equals("[")) {
            return parseArray();
        } else {
            throw new RuntimeException();
        }
    }

    private JsonObject parseObject() {
        next();
        List<Map.Entry<String, JsonValue>> members = parseMembers();
        Map<String, JsonValue> map = new HashMap<>();
        for (Map.Entry<String, JsonValue> entry : members) {
            map.put(entry.getKey(), entry.getValue());
        }
        next();
        return new JsonObject(map);
    }

    private List<Map.Entry<String, JsonValue>> parseMembers() {
        List<Map.Entry<String, JsonValue>> ret = new ArrayList<>();

        Map.Entry<String, JsonValue> member = parseMember();
        ret.add(member);
        if (peek().equals(",")) {
            next();
            List<Map.Entry<String, JsonValue>> members = parseMembers();
            ret.addAll(members);
        }

        return ret;
    }

    private Map.Entry<String, JsonValue> parseMember() {
        String key = parseKey();
        next();   // 吃掉冒号
        JsonValue value = parseValue();
        return new Map.Entry<String,JsonValue>(){

            @Override
            public String getKey() {
                return key;
            }

            @Override
            public JsonValue getValue() {
                return value;
            }

            @Override
            public JsonValue setValue(JsonValue value) {
                throw new RuntimeException();
            }
            
        };
    }


    private String parseKey() {
        String tobeMatched = jsonString.substring(pos);
        Matcher m = keyPattern.matcher(tobeMatched);
        if (m.find()) {
            String orignString = m.group(1);
            pos += orignString.length();
            return orignString.substring(1, orignString.length() - 1);
        } else {
            throw new RuntimeException();
        }
    }


    private JsonValue parseValue() {
        String tobeMatched = jsonString.substring(pos);
        Matcher m = valuePattern.matcher(tobeMatched);
        if (m.find()) {
            if (m.group(1) != null) {
                String originString = m.group(1);
                pos += originString.length();
                return new JsonStr(originString.substring(1, originString.length() - 1));
            } 

            if (m.group(2) != null) {
                String originString = m.group(2);
                pos += originString.length();
                return new JsonNum(Integer.parseInt(originString));
            }

            if (m.group(3) != null) {
                pos += 4;
                return new JsonBool(true);
            }

            if (m.group(4) != null) {
                pos += 5;
                return new JsonBool(false);
            }

            if (m.group(5) != null) {
                throw new RuntimeException();
            }

            if (m.group(6) != null) {
                return parseObject();
            }

            if (m.group(7) != null) {
                return parseArray();
            }

            throw new RuntimeException();

        } else {
            throw new RuntimeException();
        }
    }

    private JsonArray parseArray() {
        next();
        List<JsonObject> objects = parseObjects();
        next();
        return new JsonArray(objects);
    }
    

    private List<JsonObject> parseObjects() {
        List<JsonObject> ret = new ArrayList<>();

        JsonObject object = parseObject();
        ret.add(object);
        if (peek().equals(",")) {
            next();
            List<JsonObject> objects = parseObjects();
            ret.addAll(objects);
        }

        return ret;
    }

    private String next() {
        String value = peek();
        pos++;
        return value;
    }

    private String peek() {
        return jsonString.substring(pos, pos + 1);
    }



    public static void main(String[] args) {
        JsonParser parser = new JsonParser("{\"field1\":\"value1\",\"field2\":[{\"field3\":true},{\"field4\":false}]}");
        JsonValue json = parser.parse();
        System.out.println(json);
    }

    
}