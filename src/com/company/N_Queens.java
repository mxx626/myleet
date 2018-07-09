package com.company;
// Backtracking

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {
    /**
     * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



     Given an integer n, return all distinct solutions to the n-queens puzzle.

     Each solution contains a distinct board configuration of the n-queens' placement,
     where 'Q' and '.' both indicate a queen and an empty space respectively.

     Example:

     Input: 4
     Output: [
     [".Q..",  // Solution 1
     "...Q",
     "Q...",
     "..Q."],

     ["..Q.",  // Solution 2
     "Q...",
     "...Q",
     ".Q.."]
     ]
     Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        char[] line = new char[n];
        Arrays.fill(line, '.');
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[n*2];
        boolean[] diag2 = new boolean[n*2];
        helper(res, list, n, 0, col, diag1, diag2, line);
        return res;
    }

    private void helper(List<List<String>> res, List<String> list, int n, int row, boolean[] col, boolean[] diag1, boolean[] diag2, char[] line){
        if (row==n){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j=0; j<n; ++j){
            if (col[j] || diag1[j+row] || diag2[j-row+n]) continue;
            col[j]=true; diag1[j+row]=true; diag2[j-row+n]=true;
            line[j]='Q';
            list.add(new String(line));
            line[j]='.';
            helper(res, list, n, row+1, col, diag1, diag2, line);
            list.remove(list.size()-1);
            col[j]=false; diag1[j+row]=false; diag2[j-row+n]=false;
        }
    }
}
