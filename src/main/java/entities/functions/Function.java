package entities.functions;

import entities.Point;

public interface Function {
    Point[] getPoints(int numberOfPoints);
    Point[] getPointsWithMoise();
    String toString();
}
