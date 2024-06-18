package com.example.provoronoi.voronoi;

import com.example.provoronoi.shape.DelaunayTriangle;
import com.example.provoronoi.shape.Edge;

import java.util.*;

public class VoronoiDiagram {
    public VoronoiDiagram() {

    }

    public Set<Edge> createVoronoiDiagram(Set<DelaunayTriangle> triangulation) {
        Map<Edge, List<DelaunayTriangle>> adjacencyTrianglesMap = createAdjacencyTriangleMap(triangulation);
        Set<Edge> diagram = new HashSet<>();

        for (List<DelaunayTriangle> trianglesWithEdge : adjacencyTrianglesMap.values()) {
            boolean isEdgeSharedByTwoTriangles = trianglesWithEdge.size() == 2;
            if (isEdgeSharedByTwoTriangles) {
                DelaunayTriangle triangle1 = trianglesWithEdge.get(0);
                DelaunayTriangle triangle2 = trianglesWithEdge.get(1);
                addEdgeToDiagram(diagram,triangle1,triangle2);
            }
        }
        return diagram;
    }

    private void addEdgeToDiagram(Set<Edge> diagram, DelaunayTriangle triangle1, DelaunayTriangle triangle2) {
        diagram.add(new Edge(triangle1.circumcircleCenter,triangle2.circumcircleCenter));
    }

    private Map<Edge, List<DelaunayTriangle>> createAdjacencyTriangleMap(Set<DelaunayTriangle> triangulation) {
        Map<Edge, List<DelaunayTriangle>> adjacencyTrianglesMap = new HashMap<>();
        for (DelaunayTriangle triangle : triangulation) {
            Edge edge1 = new Edge(triangle.point1, triangle.point2);
            putToAdjacencyTrianglesMap(adjacencyTrianglesMap, edge1, triangle);
            Edge edge2 = new Edge(triangle.point2, triangle.point3);
            putToAdjacencyTrianglesMap(adjacencyTrianglesMap, edge2, triangle);
            Edge edge3 = new Edge(triangle.point3, triangle.point1);
            putToAdjacencyTrianglesMap(adjacencyTrianglesMap, edge3, triangle);
        }
        return adjacencyTrianglesMap;
    }

    private static void putToAdjacencyTrianglesMap(Map<Edge, List<DelaunayTriangle>> map, Edge edge,
                                                   DelaunayTriangle delaunayTriangle) {
        if (map.containsKey(edge)) {
            map.get(edge).add(delaunayTriangle);
            return;
        }
        List<DelaunayTriangle> value = new ArrayList<>();
        value.add(delaunayTriangle);
        map.put(edge,value);
    }
}
