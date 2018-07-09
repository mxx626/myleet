package com.company;
// DP
/**
 * 304. Range Sum Query 2D - Immutable

 Given a 2D matrix matrix, find the sum of the elements inside the rectangle
 defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

 Range Sum Query 2D
 The above rectangle (with the red border) is defined by (row1, col1) = (2, 1)
 and (row2, col2) = (4, 3), which contains sum = 8.

 Example:
 Given matrix = [
 [3, 0, 1, 4, 2],
 [5, 6, 3, 2, 1],
 [1, 2, 0, 1, 5],
 [4, 1, 0, 1, 7],
 [1, 0, 3, 0, 5]
 ]

 sumRegion(2, 1, 4, 3) -> 8
 sumRegion(1, 1, 2, 2) -> 11
 sumRegion(1, 2, 2, 4) -> 12
 Note:
 You may assume that the matrix does not change.
 There are many calls to sumRegion function.
 You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQuery2D_Immutable {
    private int[][] sum;
    public RangeSumQuery2D_Immutable(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) this.sum = null;
        else {
            this.sum = new int[matrix.length][matrix[0].length];
            sum[0][0] = matrix[0][0];
            for (int i=0; i<sum.length; ++i){
                for (int j=0; j<sum[0].length; ++j){
                    sum[i][j]=matrix[i][j];
                    if (i>0 && j>0) sum[i][j] += sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
                    else if (i>0) sum[i][j] += sum[i-1][j];
                    else if (j>0) sum[i][j] += sum[i][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum==null) return -1;
        if (row1>0 && col1>0) return sum[row2][col2] - sum[row1-1][col2] - sum[row2][col1-1] + sum[row1-1][col1-1];
        else if (row1>0) return sum[row2][col2] - sum[row1-1][col2];
        else if (col1>0) return sum[row2][col2] - sum[row2][col1-1];
        else return sum[row2][col2];
    }
}
