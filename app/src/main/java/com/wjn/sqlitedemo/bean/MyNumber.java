package com.wjn.sqlitedemo.bean;

public class MyNumber {

    private static double value=20;
    public static MyNumber myNumber=new MyNumber(2.8);
    public double currentvalue;

    public MyNumber(double number){
        currentvalue=value-number;
    }

}
