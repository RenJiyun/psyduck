package com.eggip.test;

public class Student extends Person{
    @Override
    public void p(){
        System.out.println("aaa");
    }
    public void a(){
        System.out.println("aaa");
    }
    public static void main(String[] args){
        Person p =new Student();
        Student student=new Student();
        Person person=new Person();
        person.p();
        student.p();

    }
}
