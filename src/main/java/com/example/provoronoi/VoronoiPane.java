package com.example.provoronoi;

import com.example.provoronoi.shape.Point;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Arrays;

public class VoronoiPane extends Pane {
    private static final int radius = 5;
    public VoronoiPane(Point[] initialPoints) {
        super();
        drawPoints(initialPoints);
    }

    private void drawPoints(Point[] points) {
        Arrays.stream(points)
                .forEach(item -> getChildren().add(new Circle(item.x, item.y, radius, Color.BLACK)));
    }
}
