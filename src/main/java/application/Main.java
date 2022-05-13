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
        Lagrange lagrange = new Lagrange();
        Plotter plt = new Plotter();

        boolean running = true;
        int counter = 1;
        while (running){
            int mode = asker.askMode();
            switch (mode) {
                case (1): {
                    int funcid = asker.askFunction();
                    if(funcid == -1) continue;
                    int steps = asker.askNumberOfPoints();
                    double step = asker.askStep();
                    double initial = asker.askInitial();

                    Point[] points = functionManager.getFunc(funcid).getPoints(steps, step, initial);
                    Point[] func = lagrange.getInterpolation(points);

                    plt.scatter(counter, points, func);
                    counter++;
                    break;
                }
                case (2): {
                    Point[] points = asker.askPoints();
                    Point[] func = lagrange.getInterpolation(points);

                    plt.scatter(counter, points, func);
                    counter++;
                    break;
                }
                case (0): {
                    running = false;
                    System.exit(0);
                }
            }
        }
    }
}
