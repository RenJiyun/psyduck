package com.eggip.suanshu;

import lombok.Getter;

@Getter
public class Node {
    private Node left;
    private Node right;
    private String value;

    public Node(Node left, Node right, String value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public int calculate() {
        if (left == null || right == null) {
            return Integer.parseInt(value);
        } else {
            int l = left.calculate();
            int r = right.calculate();
            switch (value) {
                case "+": return l + r;
                case "-": return l - r;
                case "*": return l * r;
                default: throw new RuntimeException();
            }
        }
    }

    @Override
    public String toString() {
        if (left == null || right == null) {
            // 叶子节点
            return value;
        } else {
            // 普通节点
            return left.toString() + value + right.toString();
        }
    }

    public static void main(String[] args) {
        // 3 * 7
        Node node1 = new Node(new Node(null, null, "3"), new Node(null, null, "7"), "*");
        System.out.println(node1);
        System.out.println(node1.calculate());

        // 3 * 7 - 6
        Node node2 = new Node(node1, new Node(null, null, "6"), "-");
        System.out.println(node2);
        System.out.println(node2.calculate());


        // 3 * 7 - 6 * 5
        Node node3_left = node1; 
        Node node3_right = new Node(new Node(null, null, "6"), new Node(null, null, "5"), "*");
        Node node3 = new Node(node3_left, node3_right, "-");
        System.out.println(node3);
        System.out.println(node3.calculate());

    }

}