package com.example.provoronoi.shape;

public class Edge {
    public final int point1Id;
    public final int point2Id;
    public Edge(int point1Id, int point2Id) {
        this.point1Id = point1Id;
        this.point2Id = point2Id;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "point1Id=" + point1Id + ", " +
                "point2Id=" + point2Id +
                '}';
    }
}
