package entities.functions;

import entities.Point;

public class func2 implements Function{

    @Override
    public Point[] getPoints(int numberOfPoints, double step, double initial) {
        Point[] arr = new Point[numberOfPoints];
        double point = initial;
        for(int i = 0; i < numberOfPoints; ++i){
            if(point == 0) continue;
            arr[i] = new Point(point, Math.sin(point) / point);
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
        return "f(x) = sin(x)/x";
    }
}
