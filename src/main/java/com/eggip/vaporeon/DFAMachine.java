package com.eggip.vaporeon;

public class DFAMachine {

    private DFARule dfaRule;

    public DFAMachine(DFARule dfaRule) {
        this.dfaRule = dfaRule;
    }

    public void accept(int ...endStateList) {

    }

    public boolean isAcceptable(String testString) {
        return false;
    }
    
    public static void main(String[] args) {
        DFARule dfaRule = new DFARule();
        DFAMachine dfaMachine = new DFAMachine(dfaRule);
        dfaMachine.accept(1, 2, 3);
        System.out.println(dfaMachine.isAcceptable("aabbccdd"));
    }

    
}