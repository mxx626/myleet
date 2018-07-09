package com.company;
// DP, DFS
public class TargetSum {
    private int count = 0;

    /**
     * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you
     * have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

     Find out how many ways to assign symbols to make sum of integers equal to target S.

     Example 1:
     Input: nums is [1, 1, 1, 1, 1], S is 3.
     Output: 5
     Explanation:

     -1+1+1+1+1 = 3
     +1-1+1+1+1 = 3
     +1+1-1+1+1 = 3
     +1+1+1-1+1 = 3
     +1+1+1+1-1 = 3

     There are 5 ways to assign symbols to make the sum of nums be target 3.
     Note:
     The length of the given array is positive and will not exceed 20.
     The sum of elements in the given array will not exceed 1000.
     Your output answer is guaranteed to be fitted in a 32-bit integer.
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        helper(nums, 0, 0, S);
        return count;
    }
    private void helper(int[] nums, int ptr, int sum, int target){
        if (sum==target && ptr==nums.length){
            count++;
            return;
        }
        if (ptr>=nums.length) return;
        helper(nums, ptr+1, sum+nums[ptr], target);
        helper(nums, ptr+1, sum-nums[ptr], target);
    }


    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < S || (S + sum) % 2 > 0 ? 0 : subsetSum(nums, (S + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }
}
