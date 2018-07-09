package com.company;
// DP, Math
public class IntegerBreak {
    /**
     * Given a positive integer n, break it into the sum of at least two positive
     * integers and maximize the product of those integers. Return the maximum product you can get.

     For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

     Note: You may assume that n is not less than 2 and not larger than 58.
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2; i<=n; ++i){
            for (int j=1; j<i; ++j){
                dp[i]=Math.max(dp[i], Math.max(dp[j]*(i-j), j*(i-j)));
            }
        }
        return dp[n];
    }

    public int integerBreak2(int n) {
        if (n==2) return 1;
        if (n==3) return 2;
        int res = 1;
        while (n>4){
            res *= 3;
            n -= 3;
        }
        return res*n;
    }
}
