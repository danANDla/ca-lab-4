package utils;

import entities.Point;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class Plotter {
    XYChart chart;

    public Plotter(String plotName, String xGrid, String yGrid) {
        int width = 640;
        int height = 480;
        this.chart = new XYChartBuilder().width(width).height(height).title(plotName).xAxisTitle(xGrid).yAxisTitle(yGrid).build();
    }

    public void scatter(Point[] initial, Point[] points, String name) {
        double[] xValues = new double[points.length];
        double[] yValues = new double[points.length];
        for(int i = 0; i < points.length; ++i){
            xValues[i] = points[i].getX();
            yValues[i] = points[i].getY();
        }
        XYSeries seris = chart.addSeries(name, xValues, yValues);
        seris.setMarker(SeriesMarkers.NONE);

        double[] xInitValues = new double[initial.length];
        double[] yInitValues = new double[initial.length];
        for(int i = 0; i < initial.length; ++i){
            xInitValues[i] = initial[i].getX();
            yInitValues[i] = initial[i].getY();
        }
        XYSeries  initSeris = chart.addSeries("initial", xInitValues, yInitValues);
        initSeris.setLineStyle(SeriesLines.NONE);
    }

    public void show(){
        new SwingWrapper(this.chart).displayChart();
    }
}
