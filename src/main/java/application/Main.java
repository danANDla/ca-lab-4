package application;

import entities.Point;
import entities.functions.FunctionManager;
import method.Lagrange;
import utils.Asker;
import utils.IOutil;
import utils.Plotter;

public class Main {
    public static void main(String[] args) {
        IOutil io = new IOutil();
        FunctionManager functionManager = new FunctionManager();
        Asker asker = new Asker(io, functionManager);
        Plotter plt = new Plotter("TestName", "TestX", "TestY");
        Lagrange lagrange = new Lagrange();

        boolean running = true;
        while (running) {
            int mode = asker.askMode();
            switch (mode) {
                case (1): {
                    int funcid = asker.askFunction();
                    Point[] points = functionManager.getFunc(funcid).getPoints();
                    Point[] func = lagrange.getInterpolation(points);

                    plt.scatter(points, func, "Interpolated");
                    plt.show();
                    break;
                }
                case (2): {
                    Point[] points = asker.askPoints();
                    Point[] func = lagrange.getInterpolation(points);

                    plt.scatter(points, func, "Interpolated");
                    plt.show();
                    break;
                }
                case (0): {
                    running = false;
                    break;
                }
            }
        }

    }
}
