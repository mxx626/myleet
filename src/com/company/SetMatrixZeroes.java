package com.company;
/**
 *  Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 *
 *  Follow up:
 *  Did you use extra space?
 *  A straight forward solution using O(mn) space is probably a bad idea.
 *  A simple improvement uses O(m + n) space, but still not the best solution.
 *  Could you devise a constant space solution?
 *
 *         3 1 4 0 3 5 4 0 4 1
 *         2 0 1 4 0 5 2 3 1 0
 *         0 4 3 5 3 0 5 0 1 0
 *  **/
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix==null || matrix.length==0) return;
        int rlen = matrix.length, clen = matrix[0].length;
        boolean row0=false, col0=false;
        for (int i=0; i<rlen; ++i){
            for (int j=0; j<clen; ++j){
                if (matrix[i][j]==0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) row0 = true;
                    if (j == 0) col0 = true;
                }
            }
        }
        for (int i=1; i<rlen; ++i){
            if (matrix[i][0]==0)
            for (int j=1; j<clen; ++j){
                matrix[i][j]=0;
            }
        }
        for (int i=1; i<clen; ++i){
            if (matrix[0][i]==0)
                for (int j=1; j<rlen; ++j){
                    matrix[j][i]=0;
                }
        }
        if (row0){
            for (int i=1; i<clen; ++i){
                matrix[0][i]=0;
            }
        }
        if (col0) {
            for (int i = 1; i < rlen; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}
