package application;

import utils.IOutil;
import utils.Plotter;

public class Main {
    public static void main(String[] args) {
        IOutil io = new IOutil();

        Plotter plt = new Plotter("TestName", "TestX", "TestY");

        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 32, 3, 4, 5};

        plt.scatter(x, y, "testGraph");
        plt.show();
    }
}
