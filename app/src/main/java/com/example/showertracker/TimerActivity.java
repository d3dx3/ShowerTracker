package com.example.showertracker;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

public class TimerActivity extends AppCompatActivity {

    Chronometer cTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        cTimer = findViewById(R.id.simpleChronometer);
    }

    public void startTimer (View view) {
        cTimer.start();
    }

    public void stopTimer (View view) {
        cTimer.stop();
        //TODO save to DB
        cTimer.setBase(SystemClock.elapsedRealtime());
    }


}
