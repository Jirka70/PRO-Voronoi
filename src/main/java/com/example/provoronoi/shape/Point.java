package com.example.provoronoi.shape;

public class Point {
    private static int instanceCounter = 0;
    public final double x;
    public final double y;
    public final int id;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        instanceCounter++;
        id = instanceCounter;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id + ", " +
                "x=" + x + ", " +
                "y=" + y +
                '}';
    }
}
