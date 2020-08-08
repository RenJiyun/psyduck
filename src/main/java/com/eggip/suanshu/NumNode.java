package com.eggip.suanshu;

import lombok.Getter;

@Getter
public class NumNode implements SuanshuNode {
    private int n;

    public NumNode(int n) {
        this.n = n;
    }

    @Override
    public int calculate() {
        return n;
    }
    
}