package com.wjn.sqlitedemo.bean;

import android.util.Log;

import com.wjn.sqlitedemo.myinterface.ICar;

public class BaoMa implements ICar{

    @Override
    public void drive() {
        Log.d("TAG","宝马车启动！");
    }
}
