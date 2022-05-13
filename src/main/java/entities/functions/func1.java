package entities.functions;

import entities.Point;

public class func1 implements Function{

    @Override
    public Point[] getPoints() {
        Point[] arr = new Point[10];
        arr[0] = new Point(1.2,0.932039);
        arr[1] = new Point(1.13,0.904412);
        arr[2] = new Point(1.03,0.857298989);
        arr[3] = new Point(0.5,0.4794255);
        arr[4] = new Point(0.10,0.0998334);
        arr[5] = new Point(2,0.9092974);
        arr[6] = new Point(1.91,0.94301993);
        arr[7] = new Point(1.62,0.9987897);
        arr[8] = new Point(1.32,0.9687151);
        arr[9] = new Point(1,0.84147098);
        return arr;
    }

    @Override
    public Point[] getPointsWithMoise() {
        return new Point[0];
    }

    @Override
    public String toString() {
        return "f(x) = sin(x)";
    }
}
