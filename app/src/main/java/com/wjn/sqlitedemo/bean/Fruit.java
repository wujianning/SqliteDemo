package com.wjn.sqlitedemo.bean;

import com.wjn.sqlitedemo.myinterface.FruitsVegetables;

public class Fruit implements FruitsVegetables{

    private String name;
    private String origin;
    private String price;

    public Fruit(String name,String origin,String price){
        this.name=name;
        this.origin=origin;
        this.price=price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getOrigin() {
        return origin;
    }

    @Override
    public String getPrice() {
        return price;
    }
}
