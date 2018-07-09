package com.company;
// TAG: Array, Binary Search
public class FindPeakElement {
    /**
     * A peak element is an element that is greater than its neighbors.

     Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

     The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

     You may imagine that num[-1] = num[n] = -∞.

     For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

     click to show spoilers.

     Credits:
     Special thanks to @ts for adding this problem and creating all test cases.

     * @param nums
     * @return
     */
    // Iterative solution
    public int findPeakElement(int[] nums) {
        int start=0, end=nums.length-1;
        while (start<end){
            int mid = start+(end-start)/2;
            if (nums[mid]<nums[mid+1]){
                start=mid+1;
            }
            else {
                end=mid;
            }
        }
        return start;
    }

    //Recursion solution
    public int findPeakElement2(int[] nums) {
        int start=0, end=nums.length-1;
        return search(nums, start, end);
    }
    private int search(int[] nums, int start, int end){
        if(start==end) return start;
        int mid = start+(end-start)/2;
        if (nums[mid]>nums[mid+1])
            return search (nums, start, mid);
        return search(nums, mid+1, end);
    }
}
