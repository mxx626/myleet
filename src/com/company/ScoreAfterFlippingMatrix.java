package com.company;
import java.util.Arrays;
// Bit

/**
 * 861. Score After Flipping Matrix
 *
 We have a two dimensional matrix A where each value is 0 or 1.

 A move consists of choosing any row or column, and toggling each value in that
 row or column: changing all 0s to 1s, and all 1s to 0s.

 After making any number of moves, every row of this matrix is interpreted as a
 binary number, and the score of the matrix is the sum of these numbers.

 Return the highest possible score.

 Example 1:

 Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 Output: 39
 Explanation:
 Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39

 Note:

 1 <= A.length <= 20
 1 <= A[0].length <= 20
 A[i][j] is 0 or 1.
 */
public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[] c = new int[col];
        Arrays.fill(c,1);
        int maxNum = getNum(c);
        int max = maxNum*row;
        for (int[] a : A){
            if (getNum(a)<(maxNum+1)/2){
                for (int i=0; i<a.length; ++i){
                    a[i]^=1;
                }
            }
        }
        for (int i=A[0].length-1; i>0; --i){
            if (count(A, i)>=(row+1)/2){
                for (int j=0; j<A.length; ++j){
                    A[j][i]^=1;
                }
            }
        }
        int res =0;
        for (int[] a : A){

            res +=getNum(a);
        }
        return res;
    }
    private int count(int[][] A, int c){
        int zero=0;
        for (int i=0; i<A.length; ++i){
            if (A[i][c]==0) zero++;
        }
        return zero;
    }
    private int getNum(int[] row){
        double res = 0;
        for (int i=row.length-1; i>=0; --i){
            res += Math.pow(2, row.length-1-i)*row[i];
        }
        return (int) res;
    }
}
