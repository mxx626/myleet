package com.company;
// TAG: Array, DP
import java.util.Arrays;

/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 *
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 * **/
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0][0]==1) return 0;
        int rlen = obstacleGrid.length, clen=obstacleGrid[0].length;
        int[][] dp = new int[rlen][clen];
        return helper(obstacleGrid, dp, rlen-1, clen-1);
    }

    public int helper(int[][] obstacleGrid, int[][] dp, int x, int y){
        if (x==0 && y==0) return 1;
        if (x<0 || y<0) return 0;
        if (dp[x][y]>0 && obstacleGrid[x][y]!=1) return dp[x][y];
        if (obstacleGrid[x][y]==0){
            dp[x][y] = helper(obstacleGrid, dp, x-1, y)+helper(obstacleGrid, dp, x, y-1);
        }
        else dp[x][y]=0;
        return dp[x][y];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0][0]==1) return 0;
        int rlen = obstacleGrid.length, clen=obstacleGrid[0].length;
        int[][] dp = new int[rlen][clen];
        for (int i=0; i<rlen; i++){
            if (obstacleGrid[i][0]==1) break;
            dp[i][0]=1;
        }
        for (int i=0; i<clen; i++){
            if (obstacleGrid[0][i]==1) break;
            dp[0][i]=1;
        }
        for (int i=1; i<rlen; ++i){
            for (int j=1; j<clen; ++j){
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }

            }
        }
        return dp[rlen-1][clen-1];
    }
}
