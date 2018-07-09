package HashTable;
// TAG: HashTable, Math
import java.util.HashSet;

public class LineReflection {
    /**
     * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

     Example 1:
     Given points = [[1,1],[-1,1]], return true.

     Example 2:
     Given points = [[1,1],[-1,-1]], return false.

     Follow up:
     Could you do better than O(n2)?
     * @param points
     * @return
     */
    public boolean isReflected(int[][] points) {
        HashSet<String> set = new HashSet<>();
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        for (int[] p : points){
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
            set.add(p[0]+"-"+p[1]);
        }
        int sum = max+min;
        for (int[] p : points){
            String str = (sum-p[0])+"-"+p[1];
            if (!set.contains(str)) return false;
        }
        return true;
    }
}
