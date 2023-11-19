package com.example.provoronoi;

import com.example.provoronoi.shape.Point;
import java.util.Random;

public final class PointGenerator {

    private PointGenerator() {

    }

    public static Point[] generateRandomPoints(int numberOfPoints, double windowWidth, double windowHeight) {
        Random random = new Random();
        Point[] randomPoints = new Point[numberOfPoints];

        for (int i = 0; i < numberOfPoints; i++) {
            randomPoints[i] = new Point(i,random.nextDouble() * windowWidth, random.nextDouble() * windowHeight);
        }

        return randomPoints;
    }
}
