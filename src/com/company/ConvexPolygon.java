package com.company;

import java.util.List;
// Math

/**
 * 469. Convex Polygon

 Given a list of points that form a polygon when joined sequentially, find if this polygon is
 convex (Convex polygon definition).

 Note:

 There are at least 3 and at most 10,000 points.
 Coordinates are in the range -10,000 to 10,000.
 You may assume the polygon formed by given points is always a simple polygon (Simple polygon
 definition). In other words, we ensure that exactly two edges intersect at each vertex, and
 that edges otherwise don't intersect each other.
 Example 1:

 [[0,0],[0,1],[1,1],[1,0]]

 Answer: True

 Explanation:
 Example 2:

 [[0,0],[0,10],[10,10],[10,0],[5,5]]

 Answer: False

 Explanation:
 */
public class ConvexPolygon {
    public boolean isConvex(List<List<Integer>> points) {
        int preOrient=0;
        for (int i=0; i<points.size(); ++i){
            List<Integer> point0 = points.get(i);
            List<Integer> point1 = points.get((i+1)%points.size());
            List<Integer> point2 = points.get((i+2)%points.size());
            int val = getAngle(point0, point1,point2);
            if (val==0) continue;
            if (preOrient==0){
                preOrient=val;
            }
            else if (preOrient*val<0) return false;
        }
        return true;
    }
    private int getAngle(List<Integer> point0, List<Integer> point1, List<Integer> point2){
        double val = (point1.get(1)-point0.get(1))*(point2.get(0)-point1.get(0))
                - (point2.get(1)-point1.get(1))*(point1.get(0)-point0.get(0));
        if (val>0) return 1;
        else if (val==0) return 0;
        else return -1;
    }
}
