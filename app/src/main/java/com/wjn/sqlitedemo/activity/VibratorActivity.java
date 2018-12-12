package com.wjn.sqlitedemo.activity;

import android.app.Service;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wjn.sqlitedemo.R;

public class VibratorActivity extends AppCompatActivity {

    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrator);

        vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);

        //是否支持振动器
        TextView textView1= (TextView) findViewById(R.id.activity_vibrator_textview1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean b=vibrator.hasVibrator();
                if(b){
                    Toast.makeText(VibratorActivity.this, "当前设备有振动器！" , Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(VibratorActivity.this, "当前设备无振动器！" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        //短振动器
        TextView textView2= (TextView) findViewById(R.id.activity_vibrator_textview2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.cancel();
                vibrator.vibrate(new long[]{100, 400, 600, 800}, 0);
                Toast.makeText(VibratorActivity.this, "短振动！", Toast.LENGTH_SHORT).show();
            }
        });

        //长振动器
        TextView textView3= (TextView) findViewById(R.id.activity_vibrator_textview3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.cancel();
                vibrator.vibrate(new long[]{100, 400, 600, 1800}, 0);
                Toast.makeText(VibratorActivity.this, "长振动！", Toast.LENGTH_SHORT).show();
            }
        });

        //节奏振动器
        TextView textView4= (TextView) findViewById(R.id.activity_vibrator_textview4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.cancel();
                vibrator.vibrate(new long[]{800, 200, 800, 200, 800, 200}, 0);
                Toast.makeText(VibratorActivity.this, "节奏振动！", Toast.LENGTH_SHORT).show();
            }
        });

        //取消振动器
        TextView textView5= (TextView) findViewById(R.id.activity_vibrator_textview5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.cancel();
                Toast.makeText(VibratorActivity.this, "取消振动!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
