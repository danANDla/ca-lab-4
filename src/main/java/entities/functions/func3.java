package entities.functions;

import entities.Point;

public class func3 implements Function{
    @Override
    public Point[] getPoints(int numberOfPoints, double step, double initial) {
        Point[] arr = new Point[numberOfPoints];
        double point = initial;
        for(int i = 0; i < numberOfPoints; ++i){
            arr[i] = new Point(point, 1/(1 + point * point));
            point += step;
        }
        return arr;
    }

    @Override
    public Point[] getPointsWithMoise() {
        return new Point[0];
    }

    @Override
    public String toString() {
        return "f(x) = 1/(1+x^2)";
    }
}
