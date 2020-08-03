package com.eggip.bulbasaur;

import lombok.Getter;

@Getter
public class Number implements Expr {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public Number reduce() {
        return this;
    }

}