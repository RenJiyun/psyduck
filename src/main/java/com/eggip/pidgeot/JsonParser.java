package com.eggip.pidgeot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.eggip.json.JsonArray;
import com.eggip.json.JsonBool;
import com.eggip.json.JsonNum;
import com.eggip.json.JsonObject;
import com.eggip.json.JsonStr;
import com.eggip.json.JsonValue;

public class JsonParser {

    private static final Pattern valuePattern = Pattern
            .compile("(\"[a-zA-Z0-9]*\")|([0-9]+)|(true)|(false)|(null)|(\\{.*\\})|(\\[.*\\])");
    private static final Pattern keyPattern = Pattern.compile("(\"[a-zA-Z0-9]+\"):");

    private String jsonString;
    private int pos;
    private int end;

    public JsonParser(String jsonString) {
        this.jsonString = jsonString;
        this.pos = 0;
        this.end = jsonString.length();
    }

    public JsonValue parse() {
        if (peek().equals("{")) {
            return parseJsonObject();
        } else if (peek().equals("[")) {
            return parseJsonArray();
        } else {
            throw new RuntimeException();
        }
    }

    private JsonObject parseJsonObject() {
        next();
        List<Map.Entry<String, JsonValue>> members = parseMembers();
        Map<String, JsonValue> map = new HashMap<>();
        for (Map.Entry<String, JsonValue> entry : members) {
            map.put(entry.getKey(), entry.getValue());
        }
        JsonObject jsonObject = new JsonObject(map);
        next();
        return jsonObject;
    }

    private List<Map.Entry<String, JsonValue>> parseMembers() {
        Map.Entry<String, JsonValue> member = parseMember();
        List<Map.Entry<String, JsonValue>> members = new ArrayList<>();
        members.add(member);
        if (peek().equals(",")) {
            next();
            members.addAll(parseMembers());
        }
        return members;
    }

    private Map.Entry<String, JsonValue> parseMember() {
        String key = parseKey();
        next();
        JsonValue value = parseValue();
        Map.Entry<String, JsonValue> entry = new Map.Entry<String, JsonValue>() {

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

        return entry;
    }

    private String parseKey() {
        // 利用正则表达式处理
        String toBeMatched = jsonString.substring(pos);
        Matcher m = keyPattern.matcher(toBeMatched);
        if (m.find()) {
            if (m.group(1) != null) {
                String originStr = m.group(1);
                pos += originStr.length();
                return originStr.substring(1, originStr.length() - 1);
            } else {
                throw new RuntimeException();
            }
        } else {
            throw new RuntimeException();
        }
    }

    private JsonValue parseValue() {
        String toBeMatched = jsonString.substring(pos);
        Matcher m = valuePattern.matcher(toBeMatched);
        if (m.find()) {
            if (m.group(1) != null) {
                String originStr = m.group(1);
                pos += originStr.length();
                return new JsonStr(originStr.substring(1, originStr.length() - 1));
            } 

            if (m.group(2) != null) {
                String originStr = m.group(2);
                pos += originStr.length();
                return new JsonNum(Integer.parseInt(m.group(2)));
            }

            if (m.group(3) != null) {
                String originStr = m.group(3);
                pos += originStr.length();
                return new JsonBool(true);
            }

            if (m.group(4) != null) {
                String originStr = m.group(4);
                pos += originStr.length();
                return new JsonBool(false);
            }

            if (m.group(5) != null) {
                String originStr = m.group(5);
                pos += originStr.length();
                throw new RuntimeException();
            }

            if (m.group(6) != null) {
                return parseJsonObject();
            }

            if (m.group(7) != null) {
                return parseJsonArray();
            }

            throw new RuntimeException();
        } else {
            throw new RuntimeException();
        }
    }

    private JsonArray parseJsonArray() {
        next();
        List<JsonObject> list = parseElements();
        JsonArray jsonArray = new JsonArray(list);
        next();
        return jsonArray;
    }

    private List<JsonObject> parseElements() {
        JsonObject jsonObject = parseElement();
        List<JsonObject> elements = new ArrayList<>();
        elements.add(jsonObject);
        if (peek().equals(",")) {
            next();
            elements.addAll(parseElements());
        }

        return elements;
    }

    private JsonObject parseElement() {
        return parseJsonObject();
    }

    public String peek() {
        if (pos == end) {
            return null;
        } else {
            String value = jsonString.substring(pos, pos + 1);
            return value;

        }
    }

    public String next() {
        if (pos == end) {
            return null;
        }
        String result = peek();
        pos++;
        return result;
    }

    public static void main(String[] args) {
        JsonParser parser = new JsonParser("{\"field1\":\"value1\",\"field2\":\"value2\",\"field3\":3,\"field4\":true,\"field5\":{\"field6\":\"value1\"}}");
        JsonValue json = parser.parse();
        System.out.println(json);
    }

}