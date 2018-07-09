package HashTable;
// TAG: HashTable
public class SparseMatrixMultiplication {
    /**
     * Given two sparse matrices A and B, return the result of AB.

     You may assume that A's column number is equal to B's row number.

     Example:

     A = [
     [ 1, 0, 0],
     [-1, 0, 3]
     ]

     B = [
     [ 7, 0, 0 ],
     [ 0, 0, 0 ],
     [ 0, 0, 1 ]
     ]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
     AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
     | 0 0 1 |

     * @param A
     * @param B
     * @return
     */
    public static int[][] multiply(int[][] A, int[][] B) {
        int row=A.length, c=A[0].length, col=B[0].length;
        int[][] res = new int[row][col];
        for (int i=0; i<row; ++i){
            for (int k=0; k<c; ++k){
                if (A[i][k]!=0){
                    for (int j=0; j<col; ++j){
                        if (B[k][j]!=0){
                            res[i][j] += A[i][k]*B[k][j];
                        }
                    }
                }
            }
        }
        return res;
    }
}
