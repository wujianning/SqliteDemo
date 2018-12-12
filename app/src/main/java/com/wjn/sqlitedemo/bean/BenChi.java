package com.wjn.sqlitedemo.bean;

import android.util.Log;

import com.wjn.sqlitedemo.myinterface.ICar;

public class BenChi implements ICar{

    @Override
    public void drive() {
        Log.d("TAG","奔驰车启动！");
    }
}
