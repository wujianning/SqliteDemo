package com.wjn.sqlitedemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wjn.sqlitedemo.R;
import com.wjn.sqlitedemo.view.Custom3DView;

public class MyViewActivity extends AppCompatActivity{

    private Custom3DView custom3DView;
    private TextView textView;
    private int[] mipmap=new int[]{R.mipmap.num1,R.mipmap.num2,R.mipmap.num3,R.mipmap.num4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myview);

        custom3DView= (Custom3DView) findViewById(R.id.activity_myview_customview);
        custom3DView.removeAllViewsInLayout();
        for(int i=0;i<4;i++){
            ImageView imageView=new ImageView(this);
            imageView.setBackgroundResource(mipmap[i]);
            final int position=i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MyViewActivity.this,"点击了第"+(position+1)+"张图片！",Toast.LENGTH_SHORT).show();
                }
            });
            custom3DView.addView(imageView);
        }

    }


}
