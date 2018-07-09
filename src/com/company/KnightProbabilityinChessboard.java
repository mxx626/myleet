package com.company;
import java.util.Arrays;
// DFS, DP

/**
 * 688. Knight Probability in Chessboard

 On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly
 K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right
 square is (N-1, N-1).

 A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in
 a cardinal direction, then one square in an orthogonal direction.


 Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even
 if the piece would go off the chessboard) and moves there.

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
 */
public class KnightProbabilityinChessboard {
    private int[][] dir = {{-2,-1},{-1,-2},{1,-2},{2,-1},{-2,1},{-1,2},{1,2},{2,1}};
    public double knightProbability(int N, int K, int r, int c) {
        if (K==0) return 1.0;
        double[][][] memo = new double[N][N][K+1];
        return dfs(memo, r, c, K);
    }
    private double dfs(double[][][] memo, int i, int j, int step){
        if (i<0 || i>=memo.length || j<0 || j>=memo.length){
            return 0;
        }
        if (step==0){
            return 1.0;
        }
        if (memo[i][j][step]>0)  {
            return memo[i][j][step];
        }
        double count=0;
        for (int[] d : dir){
            int x = i+d[0];
            int y = j+d[1];
            count += dfs(memo, x, y, step-1);
        }
        memo[i][j][step]=count/8.0;
        return count/8.0;
    }

    public double knightProbability2(int N, int K, int r, int c) {
        int[][] dirs = {{1, 2}, {-1,2},{-2, 1},{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1}};
        double[][] prev = new double[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(prev[i], 1);
        }
        for(int k = 0; k < K; k++){
            double[][] cur = new double[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    for(int[] dir : dirs){
                        int x = dir[0] + i;
                        int y = dir[1] + j;
                        if(x < 0 || x >= N || y < 0 || y >= N) continue;
                        cur[i][j] += prev[x][y]/8;
                    }
                }
            }
            prev = cur;
        }
        return prev[r][c];
    }
}
