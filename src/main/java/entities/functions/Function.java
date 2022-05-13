package entities.functions;

import entities.Point;

public interface Function {
    Point[] getPoints(int numberOfPoints, double step, double initial);
    Point[] getPointsWithMoise();
    String toString();
}
