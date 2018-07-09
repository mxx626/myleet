package com.company;
// DFS
/**
 * 576. Out of Boundary Paths
 *
 * There is an m by n grid with a ball. Given the start coordinate (i,j) of
 * the ball, you can move the ball to adjacent cell or cross the grid boundary
 * in four directions (up, down, left, right). However, you can at most move
 * N times. Find out the number of paths to move the ball out of grid boundary.
 * The answer may be very large, return it after mod 109 + 7.

 Example 1:
 Input:m = 2, n = 2, N = 2, i = 0, j = 0
 Output: 6
 Explanation:

 Example 2:
 Input:m = 1, n = 3, N = 3, i = 0, j = 1
 Output: 12
 Explanation:

 Note:
 Once you move the ball out of boundary, you cannot move it back.
 The length and height of the grid is in range [1,50].
 N is in range [0,50].
 */
public class OutofBoundaryPaths {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N==0) return 0;
        int[][][] memo = new int[m][n][N+1];
        return dfs(m, n, N, i, j, memo)%1000000007;
    }
    private int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
    private int dfs(int m, int n, int N, int i, int j, int[][][] memo){
        if (i<0 || i>=m || j<0 || j>=n) return 1;
        if (i-N>=0 && i+N<m && j-N>=0 && j+N <n) return 0;
        if (N<=0) return 0;
        if (memo[i][j][N]>0) return memo[i][j][N];
        int res = 0;
        for (int[] d : dir){
            int x = i+d[0];
            int y = j+d[1];
            res += dfs(m, n, N-1, x, y, memo);
            res %= 1000000007;
        }
        memo[i][j][N]=res;
        return res;
    }

    public int findPaths2(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;
        final int MOD = 1000000007;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int result = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[r][c]) % MOD;
                        }
                        else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD;
                        }
                    }
                }
            }
            count = temp;
        }
        return result;
    }
}
