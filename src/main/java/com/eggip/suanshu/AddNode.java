package com.eggip.suanshu;

import lombok.Getter;

@Getter
public class AddNode implements SuanshuNode {
    private SuanshuNode left;
    private SuanshuNode right;

    public AddNode(SuanshuNode left, SuanshuNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int calculate() {
        return left.calculate() + right.calculate();
    }
    
}