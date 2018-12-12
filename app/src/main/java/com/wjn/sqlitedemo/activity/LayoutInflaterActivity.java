package com.wjn.sqlitedemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wjn.sqlitedemo.R;
import com.wjn.sqlitedemo.view.GuaGuaLe;

public class LayoutInflaterActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layoutinflater);


        textView= (TextView) findViewById(R.id.activity_layoutinflater_textview);

        RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        layoutParams.leftMargin = 20;
        layoutParams.rightMargin=20;
        layoutParams.topMargin=20;
        layoutParams.bottomMargin=20;
        textView.setLayoutParams(layoutParams);

        textView.setTextSize(14);
        textView.setPadding(20,20,20,20);
        textView.setText("设置—TextView");

    }

}
