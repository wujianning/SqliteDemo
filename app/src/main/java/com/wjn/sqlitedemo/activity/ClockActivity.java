package com.wjn.sqlitedemo.activity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.wjn.sqlitedemo.R;

public class ClockActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        mediaPlayer = mediaPlayer.create(this,R.raw.pig);
        mediaPlayer.start();

        //创建一个闹钟提醒的对话框,点击确定关闭铃声与页面
        new AlertDialog.Builder(ClockActivity.this).setTitle("闹钟").setMessage("这是出门的闹铃！")
                .setPositiveButton("关闭闹铃", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mediaPlayer.stop();
                        ClockActivity.this.finish();
                    }
                }).show();

    }

    /**
     * onStop方法
     * */

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }

    /**
     * onDestroy方法
     * */

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}
