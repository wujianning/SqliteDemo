package com.wjn.sqlitedemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.wjn.sqlitedemo.R;

public class MyButton extends android.support.v7.widget.AppCompatButton {

    private int step;
    private String steps;

    //构造方法1
    public MyButton(Context context){
        super(context);
    }

    //构造方法2
    public MyButton(Context context, AttributeSet attrs){
        super(context, attrs);
        init(attrs);
    }

    //构造方法3
    public MyButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    //初始化
    private void init(AttributeSet attrs){
        if(attrs!=null){
            TypedArray a=getContext().obtainStyledAttributes(attrs,R.styleable.myButton);
            step=a.getInt(R.styleable.myButton_step, 0);
            steps=a.getString(R.styleable.myButton_steps);
            a.recycle();
            this.setText(step + ""+steps);
        }
    }

}
