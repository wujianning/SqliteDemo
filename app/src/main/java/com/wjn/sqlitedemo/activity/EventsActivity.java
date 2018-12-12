package com.wjn.sqlitedemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.wjn.sqlitedemo.R;
import com.wjn.sqlitedemo.view.MyButtons;
import com.wjn.sqlitedemo.view.MyLinearlayout;

public class EventsActivity extends AppCompatActivity {

    private MyButtons button;
    private MyLinearlayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        layout=(MyLinearlayout) findViewById(R.id.mylinearlayout);
        //layout触摸事件
        layout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                int action=arg1.getAction();
                switch(action){
                    case MotionEvent.ACTION_DOWN://按下
                        Log.d("TAG", "layout----<onTouch>----按下！！！");
                        break;
                    case MotionEvent.ACTION_MOVE://移动
                        Log.d("TAG", "layout----<onTouch>----移动！！！");
                        break;
                    case MotionEvent.ACTION_UP://抬起
                        Log.d("TAG", "layout----<onTouch>----抬起！！！");
                        break;
                }
                return true;
            }
        });

        //layout点击事件
        layout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Log.d("TAG", "layout----<onClick>----点击！！！");
            }
        });

        button=(MyButtons) findViewById(R.id.mybuttons);
        //button触摸事件
        button.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                int action=arg1.getAction();
                switch(action){
                    case MotionEvent.ACTION_DOWN://按下
                        Log.d("TAG", "Button----<onTouch>----按下！！！");
                        break;
                    case MotionEvent.ACTION_MOVE://移动
                        Log.d("TAG", "Button----<onTouch>----移动！！！");
                        break;
                    case MotionEvent.ACTION_UP://抬起
                        Log.d("TAG", "Button----<onTouch>----抬起！！！");
                        break;
                }
                return false;
            }
        });

        //button点击事件
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Log.d("TAG", "Button----<onClick>----点击！！！");
            }
        });
    }







    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action=ev.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN://按下
                Log.d("TAG", "Activity----<dispatchTouchEvent>----按下！！！");
                break;
            case MotionEvent.ACTION_MOVE://移动
                Log.d("TAG", "Activity----<dispatchTouchEvent>----移动！！！");
                break;
            case MotionEvent.ACTION_UP://抬起
                Log.d("TAG", "Activity----<dispatchTouchEvent>----抬起！！！");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN://按下
                Log.d("TAG", "Activity----<onTouchEvent>----按下！！！");
                break;
            case MotionEvent.ACTION_MOVE://移动
                Log.d("TAG", "Activity----<onTouchEvent>----移动！！！");
                break;
            case MotionEvent.ACTION_UP://抬起
                Log.d("TAG", "Activity----<onTouchEvent>----抬起！！！");
                break;
        }
        return super.onTouchEvent(event);
    }

}
