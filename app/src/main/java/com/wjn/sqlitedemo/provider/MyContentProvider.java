package com.wjn.sqlitedemo.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.wjn.sqlitedemo.db.DBSQLiteOpenHelper;

public class MyContentProvider extends ContentProvider {

    private Context mContext;
    private DBSQLiteOpenHelper mDbHelper = null;
    private SQLiteDatabase db = null;
    public static final String AUTOHORITY = "com.wjn.mycontentprovider";//设置ContentProvider的唯一标识 AndroidManifest.xml配置

    public static final int User_Code = 1;
    public static final int Job_Code = 2;

    // UriMatcher类使用:在ContentProvider 中注册URI
    private static final UriMatcher mMatcher;
    static{
        mMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        // 初始化
        // 若URI资源路径 = content://cn.scu.myprovider/user ，则返回注册码User_Code
        mMatcher.addURI(AUTOHORITY,"mytable", User_Code);
        // 若URI资源路径 = content://cn.scu.myprovider/job ，则返回注册码Job_Code
        mMatcher.addURI(AUTOHORITY, "mytable", Job_Code);
    }

    /**
     * delete方法 删除数据
     * */

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // 根据URI匹配 URI_CODE，从而匹配ContentProvider中相应的表名
        String table = getTableName(uri);
        return db.delete(table,selection,selectionArgs);
    }

    /**
     * getType方法 获取数据类型
     * */

    @Override
    public String getType(Uri uri) {
        // 由于不展示,此处不作展开
        return null;
    }

    /**
     * insert方法 插入数据
     * */

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // 根据URI匹配 URI_CODE，从而匹配ContentProvider中相应的表名
        String table = getTableName(uri);
        // 向该表添加数据
        db.insert(table, null, values);
        // 当该URI的ContentProvider数据发生变化时，通知外界（即访问该ContentProvider数据的访问者）
        mContext.getContentResolver().notifyChange(uri, null);
        return uri;
    }

    /**
     * onCreate方法
     * 在ContentProvider创建时对数据库进行初始化
     * 运行在主线程
     * */

    @Override
    public boolean onCreate() {
        mContext = getContext();
        mDbHelper = new DBSQLiteOpenHelper(getContext(),"cdsp.db",null,1);
        db = mDbHelper.getWritableDatabase();
        db.execSQL("delete from mytable");//删除表中所有信息 可以做别的操作
        return true;
    }

    /**
     * query方法 查询数据
     * */

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        // 根据URI匹配 URI_CODE，从而匹配ContentProvider中相应的表名
        String table = getTableName(uri);
        // 查询数据
        return db.query(table,projection,selection,selectionArgs,null,null,sortOrder,null);
    }

    /**
     * update方法 更新数据
     * */

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        // 根据URI匹配 URI_CODE，从而匹配ContentProvider中相应的表名
        String table = getTableName(uri);
        return db.update(table,values,selection,selectionArgs);
    }

    /**
     * 根据URI匹配 URI_CODE，从而匹配ContentProvider中相应的表名
     */
    private String getTableName(Uri uri){
        String tableName = null;
        switch (mMatcher.match(uri)) {
            case User_Code:
                tableName = "mytable";
                break;
            case Job_Code:
                tableName = "mytable";
                break;
        }
        return tableName;
    }

}
