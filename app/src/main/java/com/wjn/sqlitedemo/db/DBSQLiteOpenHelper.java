package com.wjn.sqlitedemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Sqlite SQLiteOpenHelper实现类
 * */

public class DBSQLiteOpenHelper extends SQLiteOpenHelper{

    /**
     * 构造方法
     * */

    public DBSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * onCreate方法
     * 首次使用软件时生成数据库表
     * */

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE mytable( id INTEGER, name VARCHAR(10), describe TEXT)";
        db.execSQL(sql);
    }

    /**
     * onUpgrade方法
     * 在数据库的版本发生变化时会被调用， 一般在软件升级时才需改变版本号
     * */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="DROP TABLE IF EXISTS mytable";
        db.execSQL(sql);
        onCreate(db);
    }

}
