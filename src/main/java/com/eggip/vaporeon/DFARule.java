package com.eggip.vaporeon;

public class DFARule {

    public void define(char c, int sourceState, int targetState) {

    }

    public int nextState(char c, int currentState) {
        return 0;
    }


    public static void main(String[] args) {
        DFARule dfaRule = new DFARule();
        dfaRule.define('a', 1, 2);
        dfaRule.define('a', 1, 3);
    }
    
}