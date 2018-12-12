package com.wjn.sqlitedemo.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.pm.ConfigurationInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import com.wjn.sqlitedemo.R;
import com.wjn.sqlitedemo.opengl.GLRenderer;
import com.wjn.sqlitedemo.opengl.GLView;
import com.wjn.sqlitedemo.view.GuaGuaLe;

public class GuaGuaLeActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guaguale);

        LinearLayout linearLayout= (LinearLayout) findViewById(R.id.activity_guaguale_linearlayout);

        GuaGuaLe guaGuaLe=new GuaGuaLe(GuaGuaLeActivity.this,"二等奖—五百万");
        linearLayout.addView(guaGuaLe);
    }

}
