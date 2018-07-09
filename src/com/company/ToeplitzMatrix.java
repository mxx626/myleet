package com.company;
// TAG: Array
import java.util.Arrays;

public class ToeplitzMatrix {
    /**
     *  matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

     Now given an M x N matrix, return True if and only if the matrix is Toeplitz.


     Example 1:

     Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
     Output: True
     Explanation:
     1234
     5123
     9512

     In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]",
     and in each diagonal all elements are the same, so the answer is True.

     Example 2:

     Input: matrix = [[1,2],[2,2]]
     Output: False
     Explanation:
     The diagonal "[1, 2]" has different elements.

     Note:

     matrix will be a 2D array of integers.
     matrix will have a number of rows and columns in range [1, 20].
     matrix[i][j] will be integers in range [0, 99].

     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length; ++i){
            for (int j=0; j<matrix[0].length; ++j){
                if (i>0 && j>0 && matrix[i-1][j-1]!=matrix[i][j])
                    return false;
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix2(int[][] matrix) {
        if (matrix==null || matrix.length==0) return true;
        int row = matrix.length, col = matrix[0].length;
        int n = Math.max(row, col);
        int[] dp = new int[2*n];
        Arrays.fill(dp, -1);
        for (int i=0; i<matrix.length; ++i){
            for (int j=0; j<matrix[0].length; ++j){
                if (dp[i-j+n]==-1) dp[i-j+n]=matrix[i][j];
                else if (matrix[i][j]!=dp[i-j+n]) return false;
            }
        }
        return true;
    }
}
