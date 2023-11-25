package com.example.provoronoi;

import com.example.provoronoi.shape.Point;
import com.example.provoronoi.shape.DelaunayTriangle;
import com.example.provoronoi.util.PointGenerator;
import com.example.provoronoi.voronoi.DelaunayTriangulation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.util.Set;

public class VoronoiApp extends Application {
    private static final int INITIAL_NUMBER_OF_POINTS = 12;
    private static final double VORONOI_PANE_WIDTH = 800;
    private static final double VORONOI_PANE_HEIGHT = 600;
    @Override
    public void start(Stage stage) {
        Point[] generatedRandomPoints = PointGenerator.generateRandomPoints(INITIAL_NUMBER_OF_POINTS,VORONOI_PANE_WIDTH,
                VORONOI_PANE_HEIGHT);
        VoronoiPane voronoiPane = new VoronoiPane(new Point[]{});
        drawTriangles(voronoiPane,generatedRandomPoints);
        Scene voronoiScene = new Scene(voronoiPane, VORONOI_PANE_WIDTH, VORONOI_PANE_HEIGHT);
        stage.setScene(voronoiScene);
        stage.show();
    }

    private void drawTriangles(VoronoiPane voronoiPane,Point[] points) {
        DelaunayTriangulation delaunayTriangulation = new DelaunayTriangulation();
        /*Set<DelaunayTriangle> delaunayTriangles = delaunayTriangulation.createTriangulation(new Point[]{new Point(146.21689331095737,560.4499485961245),
                new Point(490.1985108387147,515.226013158771),new Point(758.3267895796648,518),
                new Point(251.73337338020482,485.570108013687)
        });*/
        Set<DelaunayTriangle> delaunayTriangles = delaunayTriangulation.createTriangulation(points);
        System.out.println(delaunayTriangles.size());
        for (DelaunayTriangle delaunayTriangle : delaunayTriangles) {
            Polygon triangleToDraw = new Polygon(delaunayTriangle.point1.x, delaunayTriangle.point1.y,
                    delaunayTriangle.point2.x, delaunayTriangle.point2.y,
                    delaunayTriangle.point3.x, delaunayTriangle.point3.y);
            triangleToDraw.setFill(Color.TRANSPARENT);
            triangleToDraw.setStroke(Color.BLACK);
            voronoiPane.getChildren().add(triangleToDraw);
            voronoiPane.getChildren().add(new Circle(delaunayTriangle.circumcircleCenter.x,
                    delaunayTriangle.circumcircleCenter.y, 3, Color.RED));
        }
    }
}
