package Greedy;
// Greedy, Sort
import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points==null || points.length==0) return 0;
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });
        int count=1;
        int end = points[0][1];
        for (int i=1; i<points.length; ++i){
            if (points[i][0]>end){
                count++;
                end = points[i][1];
            }
            else{
                end = Math.min(end, points[i][1]);
            }
        }
        return count;
    }

}
