package entities.functions;

import entities.Point;

public interface Function {
    Point[] getPoints();
    Point[] getPointsWithMoise();
    String toString();
}
