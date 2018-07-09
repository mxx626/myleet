package com.company;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    /**
     * Given a non-empty array containing only positive integers, find if the array can be partitioned
     * into two subsets such that the sum of elements in both subsets is equal.
     *
     * Note:
     * Each of the array element will not exceed 100.
     * The array size will not exceed 200.
     *
     * Example 1:
     * Input: [1, 5, 11, 5]
     * Output: true
     * Explanation: The array can be partitioned as [1, 5, 5] and [11].
     *
     * Example 2:
     * Input: [1, 2, 3, 5]
     * Output: false
     * Explanation: The array cannot be partitioned into equal sum subsets.
     * **/
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int sum=0;
        for (int num : nums) sum+=num;
        if (sum%2==1) return false;
        sum/=2;
        int[] dp = new int[sum+1];
        dp[0]=1;
        for (int num : nums){
            for (int i=sum; i>0; --i){
                if (i>=num && dp[i-num]==1){
                    dp[i]= 1;
                }
            }
            if (dp[sum]==1) return true;
        }
        return false;
    }
}
