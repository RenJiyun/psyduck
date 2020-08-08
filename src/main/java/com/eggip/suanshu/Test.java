package com.eggip.suanshu;

public class Test {

    public static void main(String[] args) {
        // 3 * 5 - 8 * 6
        SuanshuNode left = new MulNode(new NumNode(3), new NumNode(5));
        SuanshuNode right = new MulNode(new NumNode(8), new NumNode(6));
        SuanshuNode node = new SubNode(left, right);
        System.out.println(node.calculate());
    }
}
