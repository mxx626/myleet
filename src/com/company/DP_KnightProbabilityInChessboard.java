package com.company;

public class DP_KnightProbabilityInChessboard {
    /**
     *  On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to
     *  make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0),
     *  and the bottom-right square is (N-1, N-1).

     A chess knight has 8 possible moves it can make, as illustrated below. Each move is two
     squares in a cardinal direction, then one square in an orthogonal direction.

     Each time the knight is to move, it chooses one of eight possible moves uniformly at
     random (even if the piece would go off the chessboard) and moves there.

     The knight continues moving until it has made exactly K moves or has moved off the chessboard.
     Return the probability that the knight remains on the board after it has stopped moving.

     Example:

     Input: 3, 2, 0, 0
     Output: 0.0625
     Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
     From each of those positions, there are also two moves that will keep the knight on the board.
     The total probability the knight stays on the board is 0.0625.

     Note:
     N will be between 1 and 25.
     K will be between 0 and 100.
     The knight always initially starts on the board.
     * **/
    private int[][] delta = new int[][]{{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        dp[r][c]=1.0;
        for (int i=0; i<K; ++i){
            double[][] tmp = new double[N][N];
            for (int row=0; row<N; ++row){
                for (int col=0; col<N; ++col){
                    for (int[] d : delta){
                        int m = row+d[0];
                        int n = col+d[1];
                        if (m<0 || n<0 || m>=N || n>=N) continue;
                        tmp[m][n]+=dp[row][col];
                    }
                }
            }
            dp=tmp;
        }

        double total=0;
        for (int i=0; i<N; ++i){
            for (int j=0; j<N; ++j){
                total+=dp[i][j];
            }
        }
        return total/Math.pow(8, K);
    }
    public double knightProbability1(int N, int K, int r, int c) {
        double[][][] dp = new double[K][N][N];
        return helper(dp, N, K, r, c)/Math.pow(8,K);
    }
    private double helper (double[][][] dp, int N, int K, int r, int c){
        if (r<0 || r>=N || c<0 || c>=N) return 0.0;
        if (K==0) return 1.0;
        if (dp[K][r][c]!=0) return dp[K][r][c];
        for (int[] d : delta){
            dp[K][r][c] += helper(dp, N, K-1, r+d[0], c+d[1]);
        }
        return dp[K][r][c];
    }
}
