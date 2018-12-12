package com.wjn.sqlitedemo.bean;

public class SonNumber extends FatherNumber{

    @Override
    public int add(int num1, int num2) {
        return num1*num2;
    }

    public int minus(int num1,int num2){
        return (num1-num2)+add(num1,num2);
    }

}
