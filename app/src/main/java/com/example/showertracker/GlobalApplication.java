package com.example.showertracker;

import android.app.Application;

import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.Date;

public class GlobalApplication extends Application {
    private BarGraphSeries<DataPoint> series;
    private Date gDateTime;

    public BarGraphSeries<DataPoint> getSeries () {
        return series;
    }
    public void setSeries (BarGraphSeries<DataPoint> newSeries) {
        this.series = newSeries;
    }

    public void setgDateTime (Date newtime) {
        gDateTime = newtime;
    }

    public Date getgDateTime () {
        return gDateTime;
    }
}