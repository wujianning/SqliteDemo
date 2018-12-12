package com.wjn.sqlitedemo.bean;

import android.support.annotation.NonNull;

public class MyBean1 implements  Comparable<MyBean1>{

    private int age;
    private String name;
    public MyBean1(int age,String name){
        this.age=age;
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(@NonNull MyBean1 myBean1) {
        return myBean1.age-this.age;
    }
}
