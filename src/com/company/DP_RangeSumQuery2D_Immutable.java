package com.company;
/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * Example:
 * Given matrix = [[3, 0, 1, 4, 2],
 *                 [5, 6, 3, 2, 1],
 *                 [1, 2, 0, 1, 5],
 *                 [4, 1, 0, 1, 7],
 *                 [1, 0, 3, 0, 5]]
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 * **/
public class DP_RangeSumQuery2D_Immutable {
    private int[][] matrix;
    private int[][] dp;
    public DP_RangeSumQuery2D_Immutable(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return;
        this.matrix = matrix;
        this.dp=new int[matrix.length+1][matrix[0].length+1];
        for (int i=0; i<matrix.length; ++i){
            for (int j=0; j<matrix[0].length; ++j){
                dp[i+1][j+1]=dp[i][j+1]+dp[i+1][j]-dp[i][j]+matrix[i][j];  //Must use memorization because it may be called a lot of times which could cause the TLB.
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2){
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        return dp[row2+1][col2+1]-dp[row1][col2+1]-dp[row2+1][col1]+dp[row1][col1];
    }

}
