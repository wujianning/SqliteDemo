package com.wjn.sqlitedemo.utils;

import com.wjn.sqlitedemo.bean.MyBean2;
import com.wjn.sqlitedemo.bean.Person;

import java.util.Comparator;

public class MyComparator2 implements Comparator<MyBean2> {

    @Override
    public int compare(MyBean2 myBean21, MyBean2 myBean22) {
        return  myBean22.getAge()-myBean21.getAge();
    }
}
