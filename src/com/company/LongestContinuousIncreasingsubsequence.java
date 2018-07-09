package com.company;
// TAG: Array
public class LongestContinuousIncreasingsubsequence {
    /**
     * Given an unsorted array of integers, find the length of longest continuous
     * increasing subsequence (subarray).

     Example 1:
     Input: [1,3,5,4,7]
     Output: 3
     Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
     Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
     Example 2:
     Input: [2,2,2,2,2]
     Output: 1
     Explanation: The longest continuous increasing subsequence is [2], its length is 1.
     Note: Length of the array will not exceed 10,000.

     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int maxLen=1, res=1;
        for (int i=1; i<nums.length; ++i){
            if (nums[i]>nums[i-1]){
                maxLen++;
            }
            else {
                maxLen=1;
            }
            res = Math.max(res, maxLen);
        }
        return res;
    }
    //Sliding window
    public int findLengthOfLCIS2(int[] nums) {
        int anchor=0, ret=0;
        for (int i=0; i<nums.length; ++i){
            if (i!=0 && nums[i-1]>=nums[i])
                anchor=i;
            ret = Math.max(ret, i-anchor+1);
        }
        return ret;
    }
}
