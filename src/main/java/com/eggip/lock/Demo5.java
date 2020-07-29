package com.eggip.lock;

import java.util.ArrayList;
import java.util.List;

public class Demo5 {
    private final List<Demo4> intList;

    
    public Demo5(List<Demo4> list) {
        this.intList = new ArrayList<>();
        intList.addAll(list);
    }


}