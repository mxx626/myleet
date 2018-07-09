package Backtracking;
// Backtracking
public class N_QueensII {
    /**
     * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



     Given an integer n, return the number of distinct solutions to the n-queens puzzle.

     Example:

     Input: 4
     Output: 2
     Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
     [
     [".Q..",  // Solution 1
     "...Q",
     "Q...",
     "..Q."],

     ["..Q.",  // Solution 2
     "Q...",
     "...Q",
     ".Q.."]
     ]
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2*n];
        boolean[] diag2 = new boolean[2*n];
        int count = helper(n, 0, 0, col, diag1, diag2);
        return count;
    }

    private int helper(int n, int row, int count, boolean[] col, boolean[] diag1, boolean[] diag2){
        int res = count;
        if (row==n) {
            res++;
        }
        else{
            for (int j=0; j<n; ++j){
                if(col[j] || diag1[j+row] || diag2[j-row+n]) continue;
                col[j]=true;
                diag1[j+row]=true;
                diag2[j-row+n]=true;
                res = helper(n, row+1, res, col, diag1, diag2);
                col[j]=false;
                diag1[j+row]=false;
                diag2[j-row+n]=false;
            }
        }
        return res;
    }
}
