package DP;
// DP
public class MaximalSquare {
    /**
     * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

     Example:

     Input:

     1 0 1 0 0
     1 0 1 1 1
     1 1 1 1 1
     1 0 0 1 0

     Output: 4

     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        int res =0;
        for (int i=1; i<=row; ++i){
            for (int j=1; j<=col; ++j){
                if (matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res*res;
    }
}
