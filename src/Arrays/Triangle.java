package Arrays;
// TAG: Array, DP.
import java.util.List;
public class Triangle {
    /**
     * Given a triangle, find the minimum path sum from top to bottom. Each step you may move
     * to adjacent numbers on the row below.

     For example, given the following triangle
     [
     [2],
     [3,4],
     [6,5,7],
     [4,1,8,3]
     ]
     The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

     Note:
     Bonus point if you are able to do this using only O(n) extra space, where n is the total
     number of rows in the triangle
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1];
        for (int i=triangle.size()-1; i>=0; --i){
            for (int j=0; j<=i; ++j){
                dp[j] = Math.min(dp[j], dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row-1).size();
        int[][] dp = new int[row][col];
        for (int i=0; i<row; ++i){
            for (int j=0; j<=i; ++j){
                dp[i][j]=triangle.get(i).get(j);
                if (i==0 && j==0) continue;
                else if (j==0) dp[i][j] += dp[i-1][j];
                else if (j==i) dp[i][j] += dp[i-1][j-1];
                else {
                    dp[i][j] += Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
            }
        }
        int res=Integer.MAX_VALUE;
        for (int i : dp[row-1]){
            if (res>i){
                res=i;
            }
        }
        return res;
    }
}
