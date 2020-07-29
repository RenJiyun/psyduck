package com.eggip.lock;

public class Holder {
    
    public static Holder holder;

    public int n;
    
    public Holder(int n) {

        this.n = n;
    }

    

    public static void main(String[] args) {
        Holder.holder = new Holder(8);  // thread1


        Holder.holder = new Holder(9); //thread2


        if (Holder.holder.n != Holder.holder.n) {  // thread3

        }


    }
    
}