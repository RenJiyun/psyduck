package com.eggip.vaporeon;

import java.util.List;

public interface FARule {
    void define(char c, int sourceState, int targetState);

    int getStartState();

    List<Integer> getEndStateList();
}