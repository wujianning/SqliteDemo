package com.wjn.sqlitedemo.activity;

import android.app.Service;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.wjn.sqlitedemo.R;

import java.io.File;
import java.io.IOException;

public class MediaRecorderAudioActivity extends AppCompatActivity {

    private boolean isstart=false;
    private MediaRecorder mediaRecorder;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediarecordaudio);

        textView= (TextView) findViewById(R.id.activity_mediarecordaudio_textview);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isstart){
                    startRecord();
                    textView.setText("停止录制");
                    isstart = true;
                }else{
                    stopRecord();
                    textView.setText("开始录制");
                    isstart = false;
                }
            }
        });
    }

    //开始录制
    private void startRecord(){
        if(mediaRecorder == null){
            File dir = new File(Environment.getExternalStorageDirectory(),"Audio");
            if(!dir.exists()){
                dir.mkdirs();
            }
            File soundFile = new File(dir,System.currentTimeMillis()+".mp3");
            if(!soundFile.exists()){
                try {
                    soundFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);//音频输入源
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_WB);//设置输出格式
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_WB);//设置编码格式
            mediaRecorder.setOutputFile(soundFile.getAbsolutePath());
            try {
                mediaRecorder.prepare();
                mediaRecorder.start();  //开始录制
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //停止录制，资源释放
    private void stopRecord(){
        if(null!=mediaRecorder){
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;
        }
    }

}
