package Math;
// Math
/**
 *
 * 812. Largest Triangle Area
 *
 * You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.

 Example:
 Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 Output: 2
 Explanation:
 The five points are show in the figure below. The red triangle is the largest.
 */
public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double res = 0;
        if (points==null || points.length<3) return 0;
        for (int i=0; i<points.length-2; ++i){
            for (int j=i+1; j<points.length-1; ++j){
                for (int k=j+1; k<points.length; ++k){
                    res = Math.max(res, area(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]));
                }
            }
        }
        return res;
    }
    private double area (int x1, int y1, int x2, int y2, int x3, int y3){
        return Math.abs(0.5*(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2)));
    }
}
