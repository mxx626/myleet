package Arrays;
// TAG: Array
public class SpiralMatrixII {
    /**
     * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

     For example,
     Given n = 3,
     You should return the following matrix:

     [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
     ]

     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int rBegin=0, rEnd=n-1;
        int cBegin=0, cEnd=n-1;
        int[][] res = new int[n][n];
        int start=1;
        while (rBegin<=rEnd && cBegin<=cEnd){
            for (int i=cBegin; i<=cEnd; ++i){
                res[rBegin][i]=start++;
            }
            rBegin++;
            for (int i=rBegin; i<=rEnd; ++i){
                res[i][cEnd]=start++;
            }
            cEnd--;
            if (rBegin<=rEnd){
                for (int i=cEnd; i>=cBegin; --i){
                    res[rEnd][i]=start++;
                }
            }
            rEnd--;
            if (cBegin<=cEnd){
                for (int i=rEnd; i>=rBegin; --i){
                    res[i][cBegin]=start++;
                }
            }
            cBegin++;
        }
        return res;
    }
}
