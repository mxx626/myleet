package com.company;
// DP
public class MaximumSubarray {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least
     * one number) which has the largest sum and return its sum.

     Example:

     Input: [-2,1,-3,4,-1,2,1,-5,4],
     Output: 6
     Explanation: [4,-1,2,1] has the largest sum = 6.
     Follow up:

     If you have figured out the O(n) solution, try coding another solution using the
     divide and conquer approach, which is more subtle.
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int[] sum = new int[nums.length+1];
        int res=Integer.MIN_VALUE;
        for (int i=0; i<nums.length; ++i){
            sum[i+1] = Math.max(sum[i]+nums[i], nums[i]);
            res = Math.max(sum[i+1], res);
        }
        return res;
    }
}
