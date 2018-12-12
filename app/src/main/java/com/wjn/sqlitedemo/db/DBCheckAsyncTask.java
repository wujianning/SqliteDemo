package com.wjn.sqlitedemo.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.TextView;

/**
 * 查询数据库数据的AsyncTask实现类
 * */

public class DBCheckAsyncTask extends AsyncTask<String, Integer, String> {

    /**
     * 构造方法
     * */

    private TextView textView;
    private SQLiteDatabase db;
    public DBCheckAsyncTask(TextView textView,SQLiteDatabase db){
        this.textView=textView;
        this.db=db;
    }

    /**
     *onPreExecute方法 执行前准备工作  UI线程
     * */

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textView.setText("数据加载中...");
    }

    /**
     * onPostExecute 返回结果 UI线程
     * */

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s);
    }

    /**
     * onProgressUpdate 更新进度 UI线程
     * */

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        textView.setText("数据加载中..."+values[0]);
    }

    /**
     * doInBackground 后台操作 非UI线程
     * */

    @Override
    protected String doInBackground(String... strings) {
        String sql=strings[0];
        Cursor cursor=db.rawQuery(sql, null);
        cursor.moveToFirst();
        StringBuilder sbBuilder=new StringBuilder();
        while(!cursor.isAfterLast()){
            int id=cursor.getInt(cursor.getColumnIndex("id"));
            sbBuilder.append("ID:"+id+"\n");
            String name=cursor.getString(cursor.getColumnIndex("name"));
            sbBuilder.append("姓名:"+name+"\n");
            String describe=cursor.getString(cursor.getColumnIndex("describe"));
            sbBuilder.append("描述:"+describe+"\n\n\n");
            cursor.moveToNext();
        }
        return sbBuilder.toString();
    }
}
