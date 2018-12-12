//package com.wjn.sqlitedemo.activity;
//
//import android.content.Context;
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
//import android.hardware.SensorManager;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.widget.TextView;
//
//import com.wjn.sqlitedemo.R;
//import com.wjn.sqlitedemo.view.CompassView;
//
//import java.util.List;
//
//public class SensorManagerActivity extends AppCompatActivity implements SensorEventListener {
//
//    private SensorManager sensorManager;
//    private Sensor sensor;
//    private CompassView compassView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        compassView = new CompassView(this);
//        //获取SensorManager实例
//        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        //获取Sensor实例
//        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
//        //注册滚动事件
//        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
//        setContentView(compassView);
//    }
//
//    /**
//     * SensorEventListener接口 onSensorChanged方法
//     * */
//
//    @Override
//    public void onSensorChanged(SensorEvent sensorEvent) {
//        compassView.setDegree(sensorEvent.values[0]);
//    }
//
//    /**
//     * SensorEventListener接口 onAccuracyChanged方法
//     * */
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int i) {
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        sensorManager.unregisterListener(this);
//    }
//}
