package com.example.provoronoi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VoronoiApp extends Application {
    private static final int INITIAL_NUMBER_OF_POINTS = 15;
    private static final double VORONOI_PANE_WIDTH = 800;
    private static final double VORONOI_PANE_HEIGHT = 600;
    @Override
    public void start(Stage stage) {
        VoronoiPane voronoiPane = new VoronoiPane(PointGenerator.generateRandomPoints(INITIAL_NUMBER_OF_POINTS,
                VORONOI_PANE_WIDTH, VORONOI_PANE_HEIGHT));

        Scene voronoiScene = new Scene(voronoiPane, VORONOI_PANE_WIDTH, VORONOI_PANE_HEIGHT);
        stage.setScene(voronoiScene);
        stage.show();
    }
}
