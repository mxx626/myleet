package com.company;
/**
 *  Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You
 *  are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 *  Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *  Find the maximum coins you can collect by bursting the balloons wisely.
 *  Note: (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 *        (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 *  Example: Given [3, 1, 5, 8] Return 167
 *  nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *  coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *  dp[i][j] = Math.max(dp[i][j], dp[i][x-1]+num[i-1]*num[x]*num[j+1]+dp[x+1][j]
 *
 *               DFS+memorizations
 * **/
public class DP_BurstBalloons {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len+2];
        for (int i=1; i<=len; i++){
            arr[i]=nums[i-1];
        }
        arr[0]=1; arr[len+1]=1;
        int[][] dp = new int[len+2][len+2];
        return helper(1, len, arr, dp);
    }
    public int helper(int i, int j, int[] arr, int[][] dp){
        if (i>j) return 0;
        if (dp[i][j]>0) return dp[i][j];  // memorization
        for (int m=i; m<=j; m++){
            dp[i][j] = Math.max(dp[i][j], helper(i, m-1, arr, dp)+helper(m+1, j, arr, dp)+arr[i-1]*arr[j+1]*arr[m]);
        }
        return dp[i][j];
    }
}
