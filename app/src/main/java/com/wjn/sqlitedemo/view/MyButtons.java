package com.wjn.sqlitedemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class MyButtons extends android.support.v7.widget.AppCompatButton {


    public MyButtons(Context context) {
        super(context);
    }

    public MyButtons(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButtons(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int action=event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN://按下
                Log.d("TAG", "Button----<dispatchTouchEvent>----按下！！！");
                break;
            case MotionEvent.ACTION_MOVE://移动
                Log.d("TAG", "Button----<dispatchTouchEvent>----移动！！！");
                break;
            case MotionEvent.ACTION_UP://抬起
                Log.d("TAG", "Button----<dispatchTouchEvent>----抬起！！！");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN://按下
                Log.d("TAG", "Button----<onTouchEvent>----按下！！！");
                break;
            case MotionEvent.ACTION_MOVE://移动
                Log.d("TAG", "Button----<onTouchEvent>----移动！！！");
                break;
            case MotionEvent.ACTION_UP://抬起
                Log.d("TAG", "Button----<onTouchEvent>----抬起！！！");
                break;
        }
        return super.onTouchEvent(event);
    }


}
