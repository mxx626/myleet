package com.company;
/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * **/
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];
        int start=1;
        int rowBegin=0, rowEnd=n-1;
        int colBegin=0, colEnd=n-1;
        while (rowBegin<=rowEnd && colBegin<=colEnd){
            for (int i=colBegin; i<=colEnd; ++i){
                res[rowBegin][i]=start++;
            }
            rowBegin++;
            for (int i=rowBegin; i<=rowEnd; ++i){
                res[i][colEnd]=start++;
            }
            colEnd--;
            if (rowBegin<=rowEnd){
                for (int i=colEnd; i>=colBegin; --i){
                    res[rowEnd][i]=start++;
                }
            }
            rowEnd--;
            if (colBegin<=colEnd){
                for (int i=rowEnd; i>=rowBegin; --i){
                    res[i][colBegin]=start++;
                }
            }
            colBegin++;
        }
        return res;
    }
}
