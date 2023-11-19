package com.example.provoronoi.shape;

public class Triangle {
    public final int point1Id;
    public final int point2Id;
    public final int point3Id;
    public Triangle(int point1Id, int point2Id, int point3Id) {
        this.point1Id = point1Id;
        this.point2Id = point2Id;
        this.point3Id = point3Id;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "point1Id=" + point1Id + ", " +
                "point2Id=" + point2Id + ", " +
                "point3Id=" + point3Id +
                '}';
    }
}
