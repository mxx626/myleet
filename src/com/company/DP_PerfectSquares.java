package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *  For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 *
 *      1   2   3   4
 *      1   2   3   1
 * **/
public class DP_PerfectSquares {
    // Dynamic Programming
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0; dp[1]=1;
        for (int i=1; i<=n; ++i){
            for (int j=1; j*j<=i; ++j){
                dp[i]=Math.min(dp[i-j*j]+1, dp[i]);
            }
        }
        return dp[n];
    }
    //Static Dynamic Programming
    private static List<Integer> res = new ArrayList<>();
    public int numSquares1(int n) {
        if (res.size()==0) res.add(0);
        while (res.size()<=n){
            int size = res.size();
            int temp = Integer.MAX_VALUE;
            for (int i=1; i*i<=size; ++i){
                temp = Math.min(temp, res.get(size-i*i)+1);
            }
            res.add(temp);
        }
        return res.get(n);
    }
}
