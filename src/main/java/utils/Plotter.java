package utils;

import entities.Point;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import javax.swing.*;
public class Plotter {

    public Plotter() {
    }
    public void scatter(int counter, Point[] initial, Point[] points) {
        int width = 640;
        int height = 480;
        XYChart chart = new XYChartBuilder().width(width).height(height).title("Graph").xAxisTitle("X").yAxisTitle("Y").build();

        double[] xValues = new double[points.length];
        double[] yValues = new double[points.length];
        String seriesname = "intital(" + counter + ")";
        String name = "interpolated(" + counter + ")";

        for (int i = 0; i < points.length; ++i) {
            xValues[i] = points[i].getX();
            yValues[i] = points[i].getY();
        }
        XYSeries seris = chart.addSeries(name, xValues, yValues);
        seris.setMarker(SeriesMarkers.NONE);

        double[] xInitValues = new double[initial.length];
        double[] yInitValues = new double[initial.length];
        for (int i = 0; i < initial.length; ++i) {
            xInitValues[i] = initial[i].getX();
            yInitValues[i] = initial[i].getY();
        }
        XYSeries initSeris = chart.addSeries(seriesname, xInitValues, yInitValues);
        initSeris.setLineStyle(SeriesLines.NONE);

        show(chart);
    }

    private void show(XYChart chart) {
        JFrame frame = new SwingWrapper(chart).displayChart();
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        System.out.println("closed");
//        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
