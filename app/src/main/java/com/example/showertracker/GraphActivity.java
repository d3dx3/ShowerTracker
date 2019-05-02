package com.example.showertracker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        Log.d("graph activity", "I AM HERE IN THE GRAPH");
        GraphView graph = (GraphView) findViewById(R.id.graph);


        //TODO Get data from DB
        try
        {
            BarGraphSeries<DataPoint> series = ((GlobalApplication)this.getApplication()).getSeries();

            //FORMATTING
            series.setTitle("ShowerTracker");

            series.setDrawValuesOnTop(true);
            series.setValuesOnTopColor(Color.RED);

            graph.getGridLabelRenderer ().setHorizontalAxisTitle ("date");
            graph.getGridLabelRenderer ().setVerticalAxisTitle ("Time");

            series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
                @Override
                public int get(DataPoint data) {
                    return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
                }
            });

            graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(graph.getContext()));
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(900);
            series.setSpacing(50);
            graph.getViewport().setYAxisBoundsManual(true);
            graph.getGridLabelRenderer().setHumanRounding(false);
            graph.addSeries(series);
        }
        catch (Exception e)
        {
            //do nothing
        }

    }

}
