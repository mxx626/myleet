package com.company;
// DP

/**
 * 303. Range Sum Query - Immutable

 Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.
 */
public class RangeSumQuery_Immutable {
    private int[] sum;
    public RangeSumQuery_Immutable(int[] nums) {
        this.sum = new int[nums.length+1];
        for (int i=0; i<nums.length; ++i){
            sum[i+1] = sum[i]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (j>=sum.length-1) j=sum.length-2;
        if (i<0) i=0;
        return sum[j+1]-sum[i];
    }
}
