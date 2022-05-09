package utils;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

public class Plotter {
    XYChart chart;

    public Plotter(String plotName, String xGrid, String yGrid) {
        int width = 640;
        int height = 480;
        this.chart = new XYChartBuilder().width(width).height(height).title(plotName).xAxisTitle(xGrid).yAxisTitle(yGrid).build();
    }

    public void scatter(double[] xValues, double[] yValues, String name) {
        chart.addSeries("name", xValues, yValues);
    }

    public void show(){
        new SwingWrapper(this.chart).displayChart();
    }
}
