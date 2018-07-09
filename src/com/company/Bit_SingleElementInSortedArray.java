package com.company;
/**
 *  Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
 *
 *  Example 1:
 *  Input: [1,1,2,3,3,4,4,8,8]
 *  Output: 2
 *
 *  Example 2:
 *  Input: [3,3,7,7,10,11,11]
 *  Output: 10
 *  Note: Your solution should run in O(log n) time and O(1) space.
 *  **/
public class Bit_SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int res=0;
        for (int num : nums){
            res=res^num;
        }
        return res;
    }
    /**
     *     0 1 2 3 4 5 6
     *     1 1 3 3 4 5 5
     *     l     m     r
     *
     *
     *
     * **/
    public int singleNonDuplicate1(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int left=0, right=nums.length-1;
        while (left<right){
            int mid = left+(right-left)/2;
            if (mid%2==1) mid--;
            if (nums[mid]!=nums[mid+1]){
                right=mid;
            }
            else {
                left=mid+2;
            }
        }
        return nums[left];
    }

}
