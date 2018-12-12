package com.wjn.sqlitedemo.bean;

import com.wjn.sqlitedemo.myinterface.ICar;

public class Driver {

    private ICar iCar;
    public Driver(ICar iCar){
        this.iCar=iCar;
    }

    public void driverCar(){
        iCar.drive();
    }

}
