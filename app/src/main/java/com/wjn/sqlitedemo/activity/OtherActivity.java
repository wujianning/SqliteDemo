package com.wjn.sqlitedemo.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.wjn.sqlitedemo.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class OtherActivity extends AppCompatActivity {

    private TextView textView;
    private WebView webView;

    private Timer timer;
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer=new Timer();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string="2018-05-30 10:36:30";
        try {
            Date date=simpleDateFormat.parse(string);
            timer.schedule(new MyTimerTask1(),date,2000);//string执行 每2秒执行一次
            Log.d("TAG","当前时间----:"+new Date().toLocaleString()+"----任务执行时间："+date.toLocaleString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * TimerTask实现类 重写run方法
     * */

    private class MyTimerTask1 extends TimerTask{
        @Override
        public void run() {//正式使用 一般Handler通讯
            count++;
            Log.d("TAG","MyTimerTask111开始执行运行时间----:"+new Date().toLocaleString()+"----count:"+count);
        }
    }

    /**
     * TimerTask实现类 重写run方法
     * */

    private class MyTimerTask2 extends TimerTask{
        @Override
        public void run() {//正式使用 一般Handler通讯
            count++;
            Log.d("TAG","MyTimerTask222开始执行运行时间----:"+new Date().toLocaleString()+"----count:"+count);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null!=timer){//取消定时器
            timer.cancel();//取消定时器
            Log.d("TAG","取消定时器！！！");
        }
    }
}
