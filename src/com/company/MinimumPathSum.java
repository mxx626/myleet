package com.company;
// TAG: Array, DP
/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to
 * bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 * Example 1:
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 * **/
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int rlen = grid.length, clen=grid[0].length;
        int[][] dp = new int[rlen][clen];
        dp[0][0]=grid[0][0];
        for (int i=0; i<rlen; ++i){
            for (int j=0; j<clen; ++j){
                if (i==0 && j==0){
                    dp[i][j]=grid[i][j];
                }
                else if (j==0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }
                else if (i==0){
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i][j-1], dp[i-1][j])+grid[i][j];
                }
            }
        }
        return dp[rlen-1][clen-1];
    }

    public int minPathSum2(int[][] grid) {
        if (grid==null || grid.length==0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        return helper(dp, grid, grid.length-1, grid[0].length-1);
    }
    public int helper(int[][] dp, int[][] grid, int x, int y){
        if (x==0 && y==0) return grid[x][y];
        if (x<0 || y<0) return Integer.MAX_VALUE;
        if (dp[x][y]>0) return dp[x][y];
        dp[x][y]=grid[x][y]+Math.min(helper(dp, grid, x-1, y), helper(dp, grid, x, y-1));
        return dp[x][y];
    }
}
