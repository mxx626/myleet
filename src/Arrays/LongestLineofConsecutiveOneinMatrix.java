package Arrays;
// TAG: Array, DP
public class LongestLineofConsecutiveOneinMatrix {
    /**
     * Given a 01 matrix M, find the longest line of consecutive one in the matrix.
     * The line could be horizontal, vertical, diagonal or anti-diagonal.
     Example:
     Input:
     [[0,1,1,0],
     [0,1,1,0],
     [0,0,0,1]]
     Output: 3
     Hint: The number of elements in the given matrix will not exceed 10,000.


     * @param M
     * @return
     */
    public int longestLine(int[][] M) {
        if (M==null || M.length==0) return 0;
        int res=0;
        int[] ver = new int[M[0].length];
        int[] dag = new int[M.length+M[0].length];
        int[] adg = new int[M.length+M[0].length];
        for (int i=0; i<M.length; ++i){
            int hor=0;
            for (int j=0; j<M[0].length; ++j){
                if (M[i][j]==1){
                    hor++;
                    ver[j]++;
                    dag[j-i+M.length]++;
                    adg[j+i]++;
                    res = Math.max(res, hor);
                    res = Math.max(res, ver[j]);
                    res = Math.max(res, dag[j-i+M.length]);
                    res = Math.max(res, adg[j+i]);
                }
                else {
                    hor=0;
                    ver[j]=0;
                    dag[j-i+M.length]=0;
                    adg[j+i]=0;
                }
            }
        }
        return res;
    }
}
