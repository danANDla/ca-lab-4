package application;

import entities.Point;
import method.Lagrange;
import utils.Asker;
import utils.IOutil;
import utils.Plotter;

public class Main {
    public static void main(String[] args) {
        IOutil io = new IOutil();
        Asker asker = new Asker(io);
        Plotter plt = new Plotter("TestName", "TestX", "TestY");
        Lagrange lagrange = new Lagrange();

        Point[] points = asker.askPoints();
        Point[] func = lagrange.getInterpolation(points);

        plt.scatter(points, func, "Interpolated");
        plt.show();
    }
}
