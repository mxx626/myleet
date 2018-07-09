package com.company;
// Backtracking
/**
 * 351. Android Unlock Patterns

 Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9,
 count the total number of unlock patterns of the Android lock screen, which consist
 of minimum of m keys and maximum n keys.

 Rules for a valid pattern:
 Each pattern must connect at least m keys and at most n keys.
 All the keys must be distinct.
 If the line connecting two consecutive keys in the pattern passes through any other
 keys, the other keys must have previously selected in the pattern. No jumps through
 non selected key is allowed.
 The order of keys used matters.

 Explanation:
 | 1 | 2 | 3 |
 | 4 | 5 | 6 |
 | 7 | 8 | 9 |
 Invalid move: 4 - 1 - 3 - 6
 Line 1 - 3 passes through key 2 which had not been selected in the pattern.

 Invalid move: 4 - 1 - 9 - 2
 Line 1 - 9 passes through key 5 which had not been selected in the pattern.

 Valid move: 2 - 4 - 1 - 3 - 6
 Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

 Valid move: 6 - 5 - 4 - 1 - 9 - 2
 Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

 Example:
 Given m = 1, n = 1, return 9.
 */
public class AndroidUnlockPatterns {
    public int numberOfPatterns(int m, int n) {
        int[][] next = new int[10][10];
        next[1][3]=next[3][1]=2;
        next[1][7]=next[7][1]=4;
        next[3][9]=next[9][3]=6;
        next[7][9]=next[9][7]=8;
        next[2][8]=next[8][2]=next[4][6]=next[6][4]=5;
        next[1][9]=next[9][1]=next[3][7]=next[7][3]=5;
        boolean[] visit = new boolean[10];
        int res = 0;
        for (int i=m; i<=n; ++i){
            res += DFS(next, visit, 1, i-1)*4+DFS(next, visit, 2, i-1)*4+DFS(next, visit, 5, i-1);
        }
        return res;
    }

    private int DFS(int[][] next, boolean[] visit, int i, int remain){
        if (remain==0) return 1;
        visit[i]=true;
        int res = 0;
        for (int j=1; j<=9; ++j){
            if (!visit[j] && (next[i][j]==0 || visit[next[i][j]])){
                res+=DFS(next, visit, j, remain-1);
            }
        }
        visit[i]=false;
        return res;
    }
}
