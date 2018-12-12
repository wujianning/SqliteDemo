package com.wjn.sqlitedemo.activity;

import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.wjn.sqlitedemo.R;
import com.wjn.sqlitedemo.view.CompassView;

public class CompassActivity extends AppCompatActivity {

    private SensorManager mSensorManager;
    private SensorEventListener mSensorEventListener;
    private CompassView chaosCompassView;
    private float val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        chaosCompassView = (CompassView) findViewById(R.id.activity_compass_compassview);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);


        mSensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                val = event.values[0];
                chaosCompassView.setVal(val);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        mSensorManager.registerListener(mSensorEventListener,mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSensorManager.unregisterListener(mSensorEventListener);
    }

}
