package com.wjn.sqlitedemo.activity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.wjn.sqlitedemo.R;

import java.util.Calendar;

public class ClockShowActivity extends Activity {

    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clockshow);

        alarmManager= (AlarmManager) getSystemService(Service.ALARM_SERVICE);
        Intent intent = new Intent(this, ClockActivity.class);
        pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        TextView textView1= (TextView) findViewById(R.id.activity_clockshow_textview1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar currentTime = Calendar.getInstance();
                new TimePickerDialog(ClockShowActivity.this, 0,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                //设置当前时间
                                Calendar c = Calendar.getInstance();
                                c.setTimeInMillis(System.currentTimeMillis());
                                // 根据用户选择的时间来设置Calendar对象
                                c.set(Calendar.HOUR, hourOfDay);
                                c.set(Calendar.MINUTE, minute);
                                // ②设置AlarmManager在Calendar对应的时间启动Activity
                                alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
                                Toast.makeText(ClockShowActivity.this, "闹钟已开启！", Toast.LENGTH_SHORT).show();
                            }
                        }, currentTime.get(Calendar.HOUR_OF_DAY), currentTime
                        .get(Calendar.MINUTE), false).show();
            }
        });


        TextView textView2= (TextView) findViewById(R.id.activity_clockshow_textview2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alarmManager.cancel(pendingIntent);
                Toast.makeText(ClockShowActivity.this, "闹钟已取消！", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
