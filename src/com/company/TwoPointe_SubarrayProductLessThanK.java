package com.company;
/**
 * Your are given an array of positive integers nums.
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 *
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 *
 * Note:
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 *              3       4       5       6       7       8       9
 *             1st
 *                      2
 * **/
public class TwoPointe_SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums==null || nums.length==0) return 0;
        int count=0, first=0, len=nums.length, product=1;
        if (k<=1) return 0;
        for (int second=0; second<len; ++second){
            product*=nums[second];
            while (product>=k) product/=nums[first++];
            count+=second-first+1;
        }
        return count;
    }
}
