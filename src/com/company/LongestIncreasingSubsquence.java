package com.company;

import java.util.Arrays;
import java.util.Stack;

/**
*Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 118, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101],
 therefore the length is 4. Note that there may be more than one LIS combination,
 it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.
    10  9   2   118    3   7   101   18
 dp  1  1   1     2    2   3     4    4
 res 1  1   1     2    2   3     4    4

 Follow up: Could you improve it to O(n log n) time complexity?

* */
public class LongestIncreasingSubsquence {
    public int lengthOfLIS(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int [] dp = new int[nums.length];
        int res=0;
        for (int i=0; i<nums.length; ++i){
            dp[i]=1;
            for (int j=0; j<i; ++j){
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            res=Math.max(res, dp[i]);
        }
        return res;
    }
    /**
            10      9       2       118     3       7       101     18
    res     0       1       1         1     2       2         3      4
    i       0       0       0         0     0       0         0      0
    j       0       1       1         1     2       2         3      4
    mid     0       0       0         0     1       1         1      2
     tails[10,]-> [9,] -> [2,]->[2,118]->[2,3]->[2,3,7]->[2,3,7,101]->[2,3,7,18]
     **/
    public int lengthOfLIS2(int[] nums){
        int[] tails = new int[nums.length];
        int res=0;
        for (int num : nums){
            int i=0, j=res;
            while (i!=j){
                int mid = i+(j-i)/2;
                if (tails[mid]<num){
                    i=mid+1;
                }
                else j=mid;
            }
            tails[i]=num;
            if (i==res) ++res;
        }
        return res;
    }
}
