package com.example.provoronoi.shape;

import com.example.provoronoi.util.PointComparator;

import java.util.Arrays;
import java.util.Objects;

public class Edge {
    public final Point point1;
    public final Point point2;
    public Edge(Point point1, Point point2) {
        Point[] points = new Point[]{point1,point2};
        Arrays.sort(points,new PointComparator());
        this.point1 = points[0];
        this.point2 = points[1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(point1, edge.point1) && Objects.equals(point2, edge.point2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2);
    }

    @Override
    public String toString() {
        return "Edge{"
                + "point1=" + point1 + ", "
                + "point2=" + point2
                + '}';
    }
}
