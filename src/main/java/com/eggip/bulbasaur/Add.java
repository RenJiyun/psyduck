package com.eggip.bulbasaur;

import lombok.Getter;

@Getter
public class Add implements Expr {

    private Expr l;
    private Expr r;

    public Add(Expr l, Expr r) {
        this.l = l;
        this.r = r;
    }

   
    @Override
    public Number reduce() {
        return new Number(l.reduce().getValue() + r.reduce().getValue());
    }
    
}