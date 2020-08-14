package com.eggip.metapod.list;


public class List<E> {
    public E head;
    public List<E> tail;

    public List(E head, List<E> tail) {
        this.head = head;
        this.tail = tail;
    }
    
    public static final List<?> nil = new List<>(null, null);


    @Override 
    public String toString() {
        List<E> rest = this;
        String s = "[";
        while (rest != nil) {
            s += rest.head;
            s += ", ";
            rest = rest.tail;
        }

        if (s.length() > 1) {
            s = s.substring(0, s.length() - 2);
        }
        s += "]";

        return s;
    }

    public static void main(String[] args) {
        // [1, 2, 3]
        List<Integer> list = new List(1, new List(2, new List(3, List.nil)));


        System.out.println(list);
    }


}