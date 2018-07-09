package DP;
// DP, Minmax
public class CanIWin {
    /**
     * In the "100 game," two players take turns adding, to a running total, any integer
     * from 1..10. The player who first causes the running total to reach or exceed 100
     * wins.

     What if we change the game so that players cannot re-use integers?

     For example, two players might take turns drawing from a common pool of numbers of
     1..15 without replacement until they reach a total >= 100.

     Given an integer maxChoosableInteger and another integer desiredTotal, determine if
     the first player to move can force a win, assuming both players play optimally.

     You can always assume that maxChoosableInteger will not be larger than 20 and
     desiredTotal will not be larger than 300.

     Example

     Input:
     maxChoosableInteger = 10
     desiredTotal = 11

     Output:
     false

     Explanation:
     No matter which integer the first player choose, the first player will lose.
     The first player can choose an integer from 1 up to 10.
     If the first player choose 1, the second player can only choose integers from 2 up to 10.
     The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
     Same with other integers chosen by the first player, the second player will always win.
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <=0) return true;
        if (maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal) return false;
        byte[] dp = new byte[1<<maxChoosableInteger];
        return helper(maxChoosableInteger, desiredTotal, 0, dp);
    }
    private boolean helper(int max, int total, int state, byte[] dp){
        if (total<=0) return false;
        if (dp[state]!=0) return dp[state]==1;
        dp[state]=1;
        for (int i=0; i<max; ++i){
            if ((state & (1<<i))>0) continue;
            if (!helper(max, total-i-1, state | 1<<i, dp)){
                return true;
            }
        }
        dp[state]=-1;
        return false;
    }
}
