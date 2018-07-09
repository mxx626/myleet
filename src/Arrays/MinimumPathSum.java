package Arrays;
// TAG: Arrays, DP
public class MinimumPathSum {
    /**
     * Given a m x n grid filled with non-negative numbers, find a path from top
     * left to bottom right which minimizes the sum of all numbers along its path.

     Note: You can only move either down or right at any point in time.

     Example 1:
     [[1,3,1],
     [1,5,1],
     [4,2,1]]
     Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.

     * @param grid
     * @return
     */
 // Fast, Fast, Fast
    public int minPathSum3(int[][] grid) {
        int row = grid.length-1, col=grid[0].length-1;
        int[] dp = new int[col+1];
        for (int i=row; i>=0; --i){
            for (int j=col; j>=0; --j){
                if (i==row && j==col) dp[j]=grid[i][j];
                else if (i==row) dp[j] = grid[i][j]+dp[j+1];
                else if (j==col) dp[j] = grid[i][j]+dp[j];
                else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j+1]);
                }
            }
        }
        return dp[0];
    }
    public int minPathSum(int[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0) return 0;
        int row = grid.length-1, col=grid[0].length-1;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i=0; i<=row; ++i){
            for (int j=0; j<=col; ++j){
                dp[i][j]=grid[i][j];
                if (i==0 && j==0) continue;
                else if (i==0) dp[i][j] += dp[i][j-1];
                else if (j==0) dp[i][j] += dp[i-1][j];
                else {
                    dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[row][col];
    }

    public int minPathSum2(int[][] grid) {
        //       if (grid==null || grid.length==0 || grid[0].length==0) return 0;
        int row = grid.length-1, col=grid[0].length-1;
        for (int i=0; i<=row; ++i){
            for (int j=0; j<=col; ++j){
                if (i==0 && j==0) continue;
                else if (i==0) grid[i][j] += grid[i][j-1];
                else if (j==0) grid[i][j] += grid[i-1][j];
                else {
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[row][col];
    }
}
