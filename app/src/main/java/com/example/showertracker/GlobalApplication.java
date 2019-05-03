package com.example.showertracker;

import android.app.Application;

import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import java.io.*;


import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.*;
import android.os.Environment;
import java.util.Date;
import java.text.SimpleDateFormat;


import java.util.Date;

public class GlobalApplication extends Application {
    private BarGraphSeries<DataPoint> series;
    private Date gDateTime;

    public BarGraphSeries<DataPoint> getSeries () {
        return series;
    }
    public void setSeries (BarGraphSeries<DataPoint> newSeries) {

        try {
            File file;
            file = new File(Environment.getExternalStorageDirectory() + File.separator + "database.txt");

            Scanner scan = new Scanner(file);

            Date tempDate;
            String str;
            int last;

            while (scan.hasNextLine()) {

                str = (String)scan.nextLine();
                last = str.lastIndexOf(' ');
                String dateStr = str.substring(0, last);

                Date date1 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss").parse(dateStr);
            }

            this.series = newSeries;
        }
        catch (Exception e) {
            System.out.println ("failed");
        }
    }

    public void setgDateTime (Date newtime) {
        gDateTime = newtime;
    }

    public Date getgDateTime () {
        return gDateTime;
    }
}