package Arrays;
// TAG: Array, DP
public class UniquePathII {
    /**
     * Follow up for "Unique Paths":

     Now consider if some obstacles are added to the grids. How many unique paths would there be?

     An obstacle and empty space is marked as 1 and 0 respectively in the grid.

     For example,
     There is one obstacle in the middle of a 3x3 grid as illustrated below.

     [
     [0,0,0],
     [0,1,0],
     [0,0,0]
     ]
     The total number of unique paths is 2.

     Note: m and n will be at most 100.


     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0 || obstacleGrid[0][0]==1) return 0;
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int[] dp = new int[c];
        dp[0]=1;
        for (int i=0; i<r; ++i){
            for (int j=0; j<c; ++j){
                if (i==0){
                    if (j==0) continue;
                    if (j!=0 && obstacleGrid[i][j]==0)
                        dp[j]=dp[j-1];
                    else break;
                }
                else if (j==0){
                    if (obstacleGrid[i][j]==0) dp[j]=dp[j];
                    else {
                        dp[j]=0;
                        continue;
                    }
                }
                else {
                    if (obstacleGrid[i][j]==0){
                        dp[j] = dp[j]+dp[j-1];
                    }
                    else dp[j]=0;
                }
            }
        }
        return dp[c-1];
    }
}
