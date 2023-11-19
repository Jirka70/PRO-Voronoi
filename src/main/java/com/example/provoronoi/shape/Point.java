package com.example.provoronoi.shape;

public class Point {
    public final double x;
    public final double y;
    public final int id;
    public Point(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
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
