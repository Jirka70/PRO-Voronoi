package com.example.provoronoi.shape;

import com.example.provoronoi.util.PointComparator;

import java.util.Arrays;
import java.util.Objects;

public class DelaunayTriangle {
    public final Point point1;
    public final Point point2;
    public final Point point3;
    public final Point circumcircleCenter;
    public final double circumcircleRadius;

    public DelaunayTriangle(Point point1, Point point2, Point point3) {
        Point[] points = new Point[]{point1,point2,point3};
        Arrays.sort(points, new PointComparator());
        this.point1 = points[0];
        this.point2 = points[1];
        this.point3 = points[2];
        circumcircleCenter = calculateCircumcircleCenter();
        circumcircleRadius = calculateEuclideanDistance(point1,circumcircleCenter);
    }

    public boolean isInCircumcircle(Point point) {
        double circumcircleRadius = calculateEuclideanDistance(point1,circumcircleCenter);
        double pointDistanceFromCircumcircleCenter = calculateEuclideanDistance(circumcircleCenter,point);
        return pointDistanceFromCircumcircleCenter < circumcircleRadius;
    }

    /**
     * @return true if triangle has point as one of its 3 vertices
     * */
    public boolean hasVertex(Point point) {
        // svetr spych
        return point1.equals(point) || point2.equals(point) || point3.equals(point);
    }

    public boolean hasEdge(Edge edge) {
        return hasVertex(edge.point1) && hasVertex(edge.point2);
    }

    private Point calculateCircumcircleCenter() {
        double ax = point1.x;
        double bx = point2.x;
        double cx = point3.x;
        double ay = point1.y;
        double by = point2.y;
        double cy = point3.y;
        double d = 2 * (ax * (by - cy) + bx * (cy - ay) + cx * (ay - by));

        double centerX = 1 / d * ((Math.pow(ax,2) + Math.pow(ay,2)) * (by - cy) + (Math.pow(bx,2)
                + Math.pow(by,2)) * (cy - ay)
                + (Math.pow(cx,2) + Math.pow(cy,2)) * (ay - by));

        double centerY = 1 / d * ((Math.pow(ax,2) + Math.pow(ay,2)) * (cx - bx)
                + (Math.pow(bx,2) + Math.pow(by,2)) * (ax - cx)
                + (Math.pow(cx,2) + Math.pow(cy,2)) * (bx - ax));

        return new Point(centerX,centerY);
    }

    private double calculateEuclideanDistance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y,2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DelaunayTriangle delaunayTriangle = (DelaunayTriangle) o;
        return Objects.equals(point1, delaunayTriangle.point1)
                && Objects.equals(point2, delaunayTriangle.point2)
                && Objects.equals(point3, delaunayTriangle.point3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2, point3);
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
