package com.eggip.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import lombok.Getter;

public class TreePrinter {

    public static void print(Node tree) {
        doPrint(tree, new Stack<>());
    }

    private static void doPrint(Node tree, Stack<Boolean> stack) {
        if (stack.size() == 0) {
            System.out.println(tree.getLabel());
        } else if (stack.size() == 1) {
            System.out.println("|-" + tree.getLabel());
        } else {
            for (int i = 0; i < stack.size() - 1; i++) {
                if (stack.get(i)) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }

                System.out.print(" ");
            }

            System.out.println("|-" + tree.getLabel());
            
        }

        if (tree.getChildren().size() > 0) {
            for (int i = 0; i < tree.getChildren().size() - 1; i++) {
                stack.push(true);
                doPrint(tree.getChildren().get(i), stack);
                stack.pop();
            }

            stack.push(false);
            doPrint(tree.getChildren().get(tree.getChildren().size() - 1), stack);
            stack.pop();
        }
    }

    @Getter
    public static class Node {
        private String label;
        private List<Node> children = new ArrayList<>();

        public Node(String label, List<Node> children) {
            this.label = label;
            this.children = children;
        }

        public Node(String label) {
            this.label = label;
        }

        public void parent(Node parent) {
            parent.children.add(this);
        }

    }

    public static void main(String[] args) {
        Node node_a = new Node("a");
        Node node_b = new Node("b");
        Node node_c = new Node("c");
        Node node_d = new Node("d");
        Node node_e = new Node("e");
        Node node_f = new Node("f");
        Node node_g = new Node("g");
        node_f.parent(node_d);
        node_e.parent(node_d);
        node_b.parent(node_a);
        node_d.parent(node_c);
        node_c.parent(node_a);
        node_g.parent(node_a);

        print(node_a);
    }

}