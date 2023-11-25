package com.example.provoronoi.util;

import com.example.provoronoi.shape.Point;

import java.util.Comparator;

public class PointComparator implements Comparator<Point> {
    /**
     * @return positive value if x cord of point1 is greater than x cord of point2 and negative value, when
     * x cord of point1 is less than x cord of point2. Whether x cords of point1 and point2 are same,
     * the same process is made for y-coords
     *
     * */
    @Override
    public int compare(Point point1, Point point2) {
        int xCordComparison = Double.compare(point1.x,point2.x);
        if (xCordComparison != 0) {
            return xCordComparison;
        }

        return Double.compare(point1.y,point2.y);
    }
}
