package com.wjn.sqlitedemo.activity;

import android.app.ActivityManager;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.wjn.sqlitedemo.R;
import com.wjn.sqlitedemo.utils.Utils;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        if(null!=savedInstanceState){
            String str=savedInstanceState.getString("StringVaule");
            int i=savedInstanceState.getInt("IntValue",0);
            Log.d("Activity_LOG","onCreatestr----:"+str);
            Log.d("Activity_LOG","onCreatei----:"+i);
        }
        Log.d("Activity_LOG","onCreate方法！！！");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        if(null!=savedInstanceState){
            String str=savedInstanceState.getString("StringVaule");
            int i=savedInstanceState.getInt("IntValue",0);
            Log.d("Activity_LOG","onCreate两个参数str----:"+str);
            Log.d("Activity_LOG","onCreate两个参数i----:"+i);
        }
        Log.d("Activity_LOG","onCreate两个参数方法！！！");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity_LOG","onStart方法！！！");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity_LOG","onResume方法！！！");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity_LOG","onPause方法！！！");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity_LOG","onStop方法！！！");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity_LOG","onDestroy方法！！！");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(null!=outState){
            outState.putString("StringVaule","adfasdfadsf");
            outState.putInt("IntValue",12);
        }
        Log.d("Activity_LOG","onSaveInstanceState方法！！！");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        if(null!=outState){
            outState.putString("StringVaule","adfasdfadsf");
            outState.putInt("IntValue",12);
        }
        Log.d("Activity_LOG","onSaveInstanceState两个参数方法！！！");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(null!=savedInstanceState){
            String str=savedInstanceState.getString("StringVaule");
            int i=savedInstanceState.getInt("IntValue",0);
            Log.d("Activity_LOG","onRestoreInstanceStatestr----:"+str);
            Log.d("Activity_LOG","onRestoreInstanceStatei----:"+i);
        }
        Log.d("Activity_LOG","onRestoreInstanceState方法！！！");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        if(null!=savedInstanceState){
            String str=savedInstanceState.getString("StringVaule");
            int i=savedInstanceState.getInt("IntValue",0);
            Log.d("Activity_LOG","onRestoreInstanceState两个参数str----:"+str);
            Log.d("Activity_LOG","onRestoreInstanceState两个参数i----:"+i);
        }
        Log.d("Activity_LOG","onRestoreInstanceState两个参数方法！！！");
    }
}
