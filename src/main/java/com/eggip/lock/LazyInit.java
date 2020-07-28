package com.eggip.lock;

import java.util.Date;

public class LazyInit {

    private volatile Date date;

    public Date getDate() {
        if (date == null) {
            synchronized(this) {
                if (date == null) {
                    date = calculateDate();
                }
            }
        }

        return date;
    }

    private Date calculateDate() {
        return new Date();
    }


    public static void main(String[] args) {
        LazyInit lazyInit = new LazyInit();

        lazyInit.getDate();
        lazyInit.getDate();
    }




    
}