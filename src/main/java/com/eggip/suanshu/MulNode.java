package com.eggip.suanshu;

import lombok.Getter;

@Getter
public class MulNode implements SuanshuNode {
    private SuanshuNode left;
    private SuanshuNode right;

    public MulNode(SuanshuNode left, SuanshuNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int calculate() {
        return left.calculate() * right.calculate();
    }
}