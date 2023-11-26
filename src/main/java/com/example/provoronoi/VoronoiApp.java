package com.example.provoronoi;

import com.example.provoronoi.shape.Edge;
import com.example.provoronoi.shape.Point;
import com.example.provoronoi.shape.DelaunayTriangle;
import com.example.provoronoi.util.PointGenerator;
import com.example.provoronoi.voronoi.DelaunayTriangulation;
import com.example.provoronoi.voronoi.VoronoiDiagram;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Set;

public class VoronoiApp extends Application {
    private static final int INITIAL_NUMBER_OF_POINTS = 3000;
    private static final double VORONOI_PANE_WIDTH = 3000;
    private static final double VORONOI_PANE_HEIGHT = 2000;
    @Override
    public void start(Stage stage) {
        Point[] generatedRandomPoints = PointGenerator.generateRandomPoints(INITIAL_NUMBER_OF_POINTS,VORONOI_PANE_WIDTH,
                VORONOI_PANE_HEIGHT);
        Pane voronoiPane = new Pane();
        draw(voronoiPane,generatedRandomPoints);
        Scene voronoiScene = new Scene(voronoiPane, VORONOI_PANE_WIDTH, VORONOI_PANE_HEIGHT);
        stage.setScene(voronoiScene);
        stage.setResizable(false);
        stage.show();
    }

    private void draw(Pane voronoiPane, Point[] points) {
        DelaunayTriangulation delaunayTriangulation = new DelaunayTriangulation();
        VoronoiDiagram voronoiDiagram = new VoronoiDiagram();
        Set<DelaunayTriangle> delaunayTriangles = delaunayTriangulation.createTriangulation(points);
        Set<Edge> diagramEdges = voronoiDiagram.createVoronoiDiagram(delaunayTriangles);

        for (Point point : points) {
            drawPoint(voronoiPane,point, Color.BLACK);
        }

        for (Edge diagramEdge : diagramEdges) {
            drawEdge(voronoiPane,diagramEdge,Color.RED);
        }
    }

    private void drawPoint(Pane voronoiPane, Point point, Color color) {
        Circle pointCircle = new Circle(point.x,point.y,5,color);
        voronoiPane.getChildren().add(pointCircle);
    }

    private void drawEdge(Pane voronoiPane, Edge edge, Color color) {
        Line lineEdge = new Line(edge.point1.x,edge.point1.y,
                edge.point2.x,edge.point2.y);
        lineEdge.setStroke(color);
        voronoiPane.getChildren().add(lineEdge);
    }

}
