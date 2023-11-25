package com.example.provoronoi.voronoi;
import com.example.provoronoi.shape.Edge;
import com.example.provoronoi.shape.Point;
import com.example.provoronoi.shape.DelaunayTriangle;

import java.util.*;

/** Computes Delaunay triangulation with Bowyer-Watson incremental algorithm */
public class DelaunayTriangulation {
    private final DelaunayTriangle superDelaunayTriangle;
    private static final double BOUND = 1E6;

    /** Creates a super triangle with vertices defined according to screen width and height */
    public DelaunayTriangulation() {
        superDelaunayTriangle = new DelaunayTriangle(new Point(BOUND/2.0,-BOUND),
                new Point(-BOUND,BOUND), new Point(BOUND,BOUND));
    }

    public Set<DelaunayTriangle> createTriangulation(Point[] points) {
        if (points == null) {
            return null;
        }

        Set<DelaunayTriangle> delaunayTriangles = new HashSet<>();
        delaunayTriangles.add(superDelaunayTriangle);
        for (Point point : points) {
            Set<DelaunayTriangle> badDelaunayTriangles = getBadTriangles(point, delaunayTriangles);
            Set<Edge> polygon = getPolygonOfBadTriangles(badDelaunayTriangles);
            removeBadTrianglesFromTriangulation(delaunayTriangles,badDelaunayTriangles);
            triangulate(point,delaunayTriangles,polygon);
        }
        return delaunayTriangles;
    }

    private void triangulate(Point newPoint, Set<DelaunayTriangle> delaunayTriangles, Set<Edge> polygon) {
        for (Edge edge : polygon) {
            delaunayTriangles.add(new DelaunayTriangle(edge.point1,edge.point2,newPoint));
        }
    }

    private void removeBadTrianglesFromTriangulation(Set<DelaunayTriangle> delaunayTriangles,
                                                     Set<DelaunayTriangle> badDelaunayTriangles) {
        delaunayTriangles.removeAll(badDelaunayTriangles);
    }

    private Set<Edge> getPolygonOfBadTriangles(Set<DelaunayTriangle> badDelaunayTriangles) {
        Set<Edge> polygon = new HashSet<>();
        for (DelaunayTriangle triangle : badDelaunayTriangles) {
            Edge edge1 = new Edge(triangle.point1,triangle.point2);
            Edge edge2 = new Edge(triangle.point2,triangle.point3);
            Edge edge3 = new Edge(triangle.point3,triangle.point1);
            if (!isEdgeSharedWithOtherBadTriangle(badDelaunayTriangles,triangle,edge1)) {
                polygon.add(edge1);
            }
            if (!isEdgeSharedWithOtherBadTriangle(badDelaunayTriangles,triangle,edge2)) {
                polygon.add(edge2);
            }
            if (!isEdgeSharedWithOtherBadTriangle(badDelaunayTriangles,triangle,edge3)) {
                polygon.add(edge3);
            }
        }
        return polygon;
    }

    private boolean isEdgeSharedWithOtherBadTriangle(Set<DelaunayTriangle> badTriangles,
                                                     DelaunayTriangle triangleWithEdge, Edge edge) {
        for (DelaunayTriangle badTriangle : badTriangles) {
            if (badTriangle.equals(triangleWithEdge)) {
                continue;
            }
            if (badTriangle.hasEdge(edge)) {
                return true;
            }
        }
        return false;
    }

    private Set<DelaunayTriangle> getBadTriangles(Point point, Set<DelaunayTriangle> delaunayTriangles) {
        Set<DelaunayTriangle> badDelaunayTriangles = new HashSet<>();
        for (DelaunayTriangle delaunayTriangle : delaunayTriangles) {
            if (delaunayTriangle.isInCircumcircle(point)) {
                badDelaunayTriangles.add(delaunayTriangle);
            }
        }
        return badDelaunayTriangles;
    }
}