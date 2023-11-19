package com.example.provoronoi.shape;

public class Triangle {
    public final Point point1;
    public final Point point2;
    public final Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "point1=" + point1 + ", " +
                "point2=" + point2 + ", " +
                "point3=" + point3 +
                '}';
    }
}
