package com.example.showertracker;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import java.io.FileWriter;
import java.io.PrintWriter;

import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Calendar;
import java.util.Date;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.*;
import android.os.Environment;

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
        //TODO fix times

//        PrintWriter file = new PrintWriter ("database.txt", "UTF-8");

        Date currentTime = Calendar.getInstance().getTime();
        long time = (SystemClock.elapsedRealtime() - cTimer.getBase()) / 1000;

        String tester = "Test";
        File file;
        FileWriter fwriter;
        BufferedWriter writer;
        try {
            file = new File (Environment.getExternalStorageDirectory() + File.separator + "database.txt");
            if (file.exists())
            {
                file.delete();
            }
            file.createNewFile();
            fwriter = new FileWriter (file);
            writer = new BufferedWriter(fwriter);
            String test = "Test Insert";

            writer.write(currentTime + " " + time + "\n");
            writer.close();
            Scanner scan = new Scanner(file);

            if (file.length() == 0)
            {
                return;
            }



        } catch (Exception e) {
            System.out.println("Failed");
        }

        double gallonsused = time * 0.042;
        Log.d ("gallons", String.valueOf(gallonsused));
        TextView timetook = findViewById(R.id.timetook);
        Resources res = getResources();
        String text = String.format(res.getString(R.string.timetookplacement), gallonsused);
        timetook.setText(text);

        BarGraphSeries<DataPoint> newSeries = new BarGraphSeries<> (new DataPoint[]
                {
                        new DataPoint(currentTime, time)
                });
        ((GlobalApplication)this.getApplication()).setSeries(newSeries);
        cTimer.setBase(SystemClock.elapsedRealtime());


    }


}
