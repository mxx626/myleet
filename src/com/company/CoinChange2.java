package com.company;
// DP
public class CoinChange2 {
    /**
     * ou are given coins of different denominations and a total amount of money.
     * Write a function to compute the number of combinations that make up that
     * amount. You may assume that you have infinite number of each kind of coin.

     Note: You can assume that

     0 <= amount <= 5000
     1 <= coin <= 5000
     the number of coins is less than 500
     the answer is guaranteed to fit into signed 32-bit integer
     Example 1:

     Input: amount = 5, coins = [1, 2, 5]
     Output: 4
     Explanation: there are four ways to make up the amount:
     5=5
     5=2+2+1
     5=2+1+1+1
     5=1+1+1+1+1
     * @param amount
     * @param coins
     * @return
     */

    /**
     * 定义子问题dp[i][j] : 用前i种硬币组成金额j的总组合数
     最终目标：dp[n][amount]
     状态迁移方程：
     求dp[i][j]时：
     （1）不加入此种币值：dp[i][j]=dp[i-1][j];
     （2）加入此种币值：那么加入该枚硬币之后构成j分的方法数也为ways[i][j-coins[i-1]]。
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0]=1;
        for (int i=1; i<=coins.length; ++i){
            dp[i][0]=1;
            for (int j=1; j<=amount; ++j){
                dp[i][j]=dp[i-1][j] + (j>=coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0]=1;
        for (int i=0; i<coins.length; ++i){
            for (int j=coins[i]; j<=amount; ++j){
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
