package DP;

public class DominoandTrominoTiling {
    /**
     * We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. These shapes may be rotated.
     * XX  <- domino
     * XX  <- "L" tromino
     * X
     * Given N, how many ways are there to tile a 2 x N board? Return your answer modulo 10^9 + 7.
     * (In a tiling, every square must be covered by a tile. Two tilings are different if and only if there
     * are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both
     * squares occupied by a tile.)
     *
     * Example:
     * Input: 3
     * Output: 5
     * Explanation:
     * The five different ways are listed below, different letters indicates different tiles:
     * XYZ XXZ XYY XXY XYY
     * XYZ YYZ XZZ XYY XXY
     *
     * Note:
     * N  will be in range [1, 1000].
     * **/
    private static final int num = 1000000007;
    public int numTilings(int N) {
        int[][] dp = new int[N+1][2];
        dp[0][0]=1; dp[1][0]=1;
        for (int i=2; i<=N; ++i){
            dp[i][0] = (dp[i-1][0]%num+(dp[i-2][0]%num+(2*dp[i-1][1])%num)%num)%num;
            dp[i][1] = (dp[i-2][0]%num+dp[i-1][1]%num)%num;
        }
        return dp[N][0];
    }
}
