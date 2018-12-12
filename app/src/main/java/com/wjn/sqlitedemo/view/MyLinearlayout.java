package com.wjn.sqlitedemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MyLinearlayout extends LinearLayout {


    public MyLinearlayout(Context context) {
        super(context);
    }


    public MyLinearlayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public MyLinearlayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int action=event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN://按下
                Log.d("TAG", "Linearlayout----<dispatchTouchEvent>----按下！！！");
                break;
            case MotionEvent.ACTION_MOVE://移动
                Log.d("TAG", "Linearlayout----<dispatchTouchEvent>----移动！！！");
                break;
            case MotionEvent.ACTION_UP://抬起
                Log.d("TAG", "Linearlayout----<dispatchTouchEvent>----抬起！！！");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action=ev.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN://按下
                Log.d("TAG", "Linearlayout----<onInterceptTouchEvent>----按下！！！");
                break;
            case MotionEvent.ACTION_MOVE://移动
                Log.d("TAG", "Linearlayout----<onInterceptTouchEvent>----移动！！！");
                break;
            case MotionEvent.ACTION_UP://抬起
                Log.d("TAG", "Linearlayout----<onInterceptTouchEvent>----抬起！！！");
                break;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN://按下
                Log.d("EventsActivity", "Linearlayout----<onTouchEvent>----按下！！！");
                break;
            case MotionEvent.ACTION_MOVE://移动
                Log.d("EventsActivity", "Linearlayout----<onTouchEvent>----移动！！！");
                break;
            case MotionEvent.ACTION_UP://抬起
                Log.d("EventsActivity", "Linearlayout----<onTouchEvent>----抬起！！！");
                break;
        }
        return super.onTouchEvent(event);
    }


}

