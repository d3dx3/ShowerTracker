package com.example.showertracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ArrayList<Long> mTimes;
    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = (TextView) findViewById(R.id.message);
        final Button timerButton = findViewById(R.id.button_timer);
        timerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v) {
                Intent intent = new Intent(v.getContext(), TimerActivity.class);
                startActivity(intent);
            }});
        final Button graphButton = findViewById(R.id.button_graph);
        graphButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                Intent intent = new Intent(v.getContext(), GraphActivity.class);
                startActivity(intent);
            }});
    }

}
