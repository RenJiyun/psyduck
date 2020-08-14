package com.eggip.metapod.list;


public class List<E> {
    public E head;
    public List<E> tail;

    public List(E head, List<E> tail) {
        this.head = head;
        this.tail = tail;
    }
    
    public static final List<?> nil = new List<>(null, null);
}