package com.wjn.sqlitedemo.activity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wjn.sqlitedemo.R;
import com.wjn.sqlitedemo.bean.Person;
import com.wjn.sqlitedemo.db.DBCheckAsyncTask;
import com.wjn.sqlitedemo.db.DBSQLiteOpenHelper;
import com.wjn.sqlitedemo.login.view.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private DBSQLiteOpenHelper dbsqLiteOpenHelper;
    private SQLiteDatabase db;
    private int id=111;
    private int page=1;
    private int pageNum=3;

    private  Uri uri_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1= (TextView) findViewById(R.id.activity_main_textview1);
        textView2= (TextView) findViewById(R.id.activity_main_textview2);
        textView3= (TextView) findViewById(R.id.activity_main_textview3);
        textView4= (TextView) findViewById(R.id.activity_main_textview4);
        textView5= (TextView) findViewById(R.id.activity_main_textview5);
        textView6= (TextView) findViewById(R.id.activity_main_textview6);



        /**
         * 对mytable表进行操作
         */

        // 设置URI
        uri_user = Uri.parse("content://com.wjn.mycontentprovider/mytable");













        dbsqLiteOpenHelper=new DBSQLiteOpenHelper(MainActivity.this,"cdsp.db",null,1);

        //增
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                // 插入表中数据
//                ContentValues values = new ContentValues();
//                values.put("id", 1);
//                values.put("name", "詹姆斯");
//                values.put("describe", "大家好，我是詹姆斯！");
//                // 获取ContentResolver
//                ContentResolver resolver =  getContentResolver();
//                // 通过ContentResolver 根据URI 向ContentProvider中插入数据
//                resolver.insert(uri_user,values);




                Intent intent=new Intent(MainActivity.this,MarginLayoutParamsActivity.class);
                startActivity(intent);

                db=dbsqLiteOpenHelper.getReadableDatabase();
                Person person=new Person();
                person.setId(String.valueOf(id));
                person.setName("张三"+id);
                person.setDescribe("本章节讲述getWritableDatabase()和getReadableDatabase()区别");
                insert(person);
                id=id+100;
            }
        });

        //删
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取ContentResolver
                ContentResolver resolver =  getContentResolver();
                resolver.delete(uri_user,"id=1",null);


//                delete("111");
            }
        });

        //改
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取ContentResolver
                ContentResolver resolver =  getContentResolver();
                ContentValues values=new ContentValues();//类似于map
                values.put("name","API修改");
                values.put("describe","大家好，我修改成功了！");
                resolver.update(uri_user,values,"id=1",null);

//                Person person=new Person();
//                person.setId("211");
//                person.setName("修改");
//                person.setDescribe("修改描述");
//                update(person);

//                long count=getCount();
//                textView6.setText(count+"条");
            }
        });

        //查
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取ContentResolver
                ContentResolver resolver =  getContentResolver();
                // 通过ContentResolver 向ContentProvider中查询数据
                Cursor cursor = resolver.query(uri_user, new String[]{"id","name","describe"}, null, null, null);
                StringBuilder sbBuilder=new StringBuilder();
                while (cursor.moveToNext()){
                    int id=cursor.getInt(cursor.getColumnIndex("id"));
                    sbBuilder.append("ID:"+id+"\n");
                    String name=cursor.getString(cursor.getColumnIndex("name"));
                    sbBuilder.append("姓名:"+name+"\n");
                    String describe=cursor.getString(cursor.getColumnIndex("describe"));
                    sbBuilder.append("描述:"+describe+"\n\n\n");
                }
                textView6.setText(sbBuilder.toString());
                cursor.close();// 关闭游标


                db=dbsqLiteOpenHelper.getReadableDatabase();
                new DBCheckAsyncTask(textView6,db).execute("select * from mytable");

                check();
            }
        });

        //清空数据
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                db=dbsqLiteOpenHelper.getReadableDatabase();
//                db.execSQL("DELETE FROM mytable");

                List<Person> list=getScrollData(page,pageNum);
                StringBuilder sbBuilder=new StringBuilder();
                for(int i=0;i<list.size();i++){
                    Person person=list.get(i);
                    sbBuilder.append("ID:"+person.getId()+"\n");
                    sbBuilder.append("姓名:"+person.getName()+"\n");
                    sbBuilder.append("描述:"+person.getDescribe()+"\n\n\n");
                }
                textView6.setText(sbBuilder.toString());
                page++;

            }
        });
    }

    /**
     * 插入数据
     * */

    public void insert(Person p) {
        db=dbsqLiteOpenHelper.getReadableDatabase();
        db.execSQL("INSERT INTO mytable(id,name,describe) values(?,?,?)",
                new String[]{p.getId(), p.getName(),p.getDescribe()});
    }

    /**
     * 删除数据
     * */

    public void delete(String id) {
        db=dbsqLiteOpenHelper.getReadableDatabase();
        db.execSQL("DELETE FROM mytable WHERE id = ?",
                new String[]{id});
    }

    /**
     * 修改数据
     * */

    public void update(Person p) {
        db=dbsqLiteOpenHelper.getReadableDatabase();
        db.execSQL("UPDATE mytable SET name = ?,describe = ? WHERE id = ?",
                new String[]{p.getName(), p.getDescribe(), p.getId()});
    }

    /**
     * 查询数据
     * */

    public void check() {
        db=dbsqLiteOpenHelper.getReadableDatabase();
        String sql="select * from mytable";
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
        textView6.setText(sbBuilder.toString());
        db.close();
    }

    /**
     * 查询条目
     * */

    public long getCount() {
        db=dbsqLiteOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT (*) FROM mytable", null);
        cursor.moveToFirst();
        long result = cursor.getLong(0);
        cursor.close();
        return result;
    }

    /**
     * 数据分页显示
     * limit 2,3; 从第2+1条开始显示 显示3条记录;
     * */

    public List<Person> getScrollData(int offset, int maxResult) {
        List<Person> person = new ArrayList<Person>();
        db=dbsqLiteOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM mytable ORDER BY id ASC LIMIT"+" ?,?",
                new String[]{String.valueOf(offset), String.valueOf(maxResult)});
        while (cursor.moveToNext()) {
            Person persons=new Person();
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String describe = cursor.getString(cursor.getColumnIndex("describe"));
            persons.setId(String.valueOf(id));
            persons.setName(name);
            persons.setDescribe(describe);
            person.add(persons);
        }
        cursor.close();
        return person;
    }

}
