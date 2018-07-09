package com.company;
// DP
public class MaximumProductSubarray {
    /**
     * Given an integer array nums, find the contiguous subarray within an array
     * (containing at least one number) which has the largest product.

     Example 1:

     Input: [2,3,-2,4]
     Output: 6
     Explanation: [2,3] has the largest product 6.
     Example 2:

     Input: [-2,0,-1]
     Output: 0
     Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int max = nums[0], min = nums[0];
        int res = max;
        for (int i=1; i<nums.length; ++i){
            int tmp = max;
            max = Math.max(max*nums[i], Math.max(min*nums[i], nums[i]));
            min = Math.min(min*nums[i], Math.min(tmp*nums[i], nums[i]));
            res = Math.max(res, max);
        }
        return res;
    }
}
