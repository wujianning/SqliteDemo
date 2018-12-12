package com.wjn.sqlitedemo.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.pm.ConfigurationInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.SeekBar;
import android.widget.Toast;

import com.wjn.sqlitedemo.R;
import com.wjn.sqlitedemo.opengl.GLRenderer;
import com.wjn.sqlitedemo.opengl.GLView;

public class OpenGLESActivity extends Activity {

    private boolean supportsEs2;
    private GLView glView;
    private float rotateDegree = 0;
    private GLRenderer glRenderer;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opengles);
        checkSupported();
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        if (supportsEs2) {
            glView = (GLView) findViewById(R.id.glView);
            glRenderer = new GLRenderer(this);
            glView.setRenderer(glRenderer);

        } else {

            Toast.makeText(this, "当前设备不支持OpenGL ES 2.0!", Toast.LENGTH_SHORT).show();
        }
        seekBar.setMax(100);

        seekBar.setProgress(80);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                glRenderer.setScale(1f * progress / 100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void rotate(float degree) {
        glRenderer.rotate(degree);
        glView.invalidate();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            rotate(rotateDegree);
        }
    };


    /**
     * 当前设备是否支持OpenGL ES 2.0
     * */

    private boolean IsSupported() {
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000
                ||(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1 && (Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")));
        return supportsEs2;
    }

    private void checkSupported() {
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        supportsEs2 = configurationInfo.reqGlEsVersion >= 0x2000;

        boolean isEmulator = Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1
                && (Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86"));

        supportsEs2 = supportsEs2 || isEmulator;
    }

    /**
     * onPause方法 glSurfaceView.onPause
     * */

    @Override
    protected void onPause() {
        super.onPause();
        if (glView != null) {
            glView.onPause();
        }
    }

    /**
     * onResume方法 glSurfaceView.onResume
     * */

    @Override
    protected void onResume() {
        super.onResume();
        glRenderer.setScale(0.8f);
        if (glView != null) {
            glView.onResume();

            //不断改变rotateDegreen值，实现旋转
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            sleep(100);

                            rotateDegree += 5;
                            handler.sendEmptyMessage(0x001);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            }.start();
        }
    }

}
