package com.wjn.sqlitedemo.activity;

import android.app.Service;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.wjn.sqlitedemo.R;

import static com.wjn.sqlitedemo.R.id.activity_windowmanager_textview1;

public class WindowManagerActivity extends AppCompatActivity {

    private AudioManager audioManager;
    private MediaPlayer mediaPlayer;
    private boolean ismute=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windowmanager);

        //获得系统的音频对象
        audioManager = (AudioManager) getSystemService(Service.AUDIO_SERVICE);
        //初始化mediaplayer对象,这里播放的是raw文件中的mp3资源
        mediaPlayer = MediaPlayer.create(this, R.raw.pig);
        //设置循环播放:
        mediaPlayer.setLooping(true);

        //播放
        TextView textView1= (TextView) findViewById(R.id.activity_windowmanager_textview1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        //停止
        TextView textView2= (TextView) findViewById(R.id.activity_windowmanager_textview2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        //高音量
        TextView textView3= (TextView) findViewById(R.id.activity_windowmanager_textview3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 指定调节音乐的音频，增大音量，而且显示音量图形示意
                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
            }
        });

        //低音量
        TextView textView4= (TextView) findViewById(R.id.activity_windowmanager_textview4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 指定调节音乐的音频，降低音量，而且显示音量图形示意
                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
            }
        });

        //静音
        final TextView textView5= (TextView) findViewById(R.id.activity_windowmanager_textview5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!ismute){
                    audioManager.setStreamMute(AudioManager.STREAM_MUSIC, true);   //API 23过期- -
//                    audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE,AudioManager.FLAG_SHOW_UI);   //23以后的版本用这个
                    ismute=true;
                    textView5.setText("取消静音");
                }else{
                    audioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);//API 23过期- -
//                    audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_UNMUTE,AudioManager.FLAG_SHOW_UI);  //23以后的版本用这个
                    audioManager.setMicrophoneMute(false);
                    ismute=false;
                    textView5.setText("静音");
                }
            }
        });

    }
}
