package com.company;
// TAG: Array
public class Non_DecreasingArray {
    /**
     *  Given an array with n integers, your task is to check if it could become
     *  non-decreasing by modifying at most 1 element.

     We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

     Example 1:

     Input: [4,2,3]
     Output: True
     Explanation: You could modify the first 4 to 1 to get a non-decreasing array.

     Example 2:

     Input: [4,2,1]
     Output: False
     Explanation: You can't get a non-decreasing array by modify at most one element.

     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int count=0;
        for (int i=1; i<nums.length&&count<=1; ++i){
            if (nums[i]<nums[i-1]){
                if (i-2<0 || nums[i-2]<nums[i]){
                    nums[i-1]=nums[i];
                }
                else {
                    nums[i]=nums[i-1];
                }
                count++;
            }
        }
        return count<=1;
    }
}
