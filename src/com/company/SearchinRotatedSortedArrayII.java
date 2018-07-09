package com.company;
// TAG: Array, Binary Search
public class SearchinRotatedSortedArrayII {
    /**
     *

     Follow up for "Search in Rotated Sorted Array":
     What if duplicates are allowed?

     Would this affect the run-time complexity? How and why?

     Suppose an array sorted in ascending order is rotated at some
     pivot unknown to you beforehand.

     (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

     Write a function to determine if a given target is in the array.

     The array may contain duplicates.
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums==null || nums.length==0) return false;
        int start=0, end=nums.length-1;
        return helper(nums, target, start, end);
    }
    private boolean helper(int[] nums, int target, int start, int end){
        if (start>end) return false;
        int mid = (end-start)/2 + start;
        if (nums[mid]==target) return true;
        if (nums[mid]>nums[start]){
            if (target>=nums[start] && target<nums[mid]){
                return helper(nums, target, start, mid-1);
            }
            else return helper(nums, target, mid+1, end);
        }
        else if (nums[mid]<nums[start]){
            if (target>nums[mid] && target<=nums[end]){
                return helper(nums, target, mid+1, end);
            }
            else return helper(nums, target, start, mid-1);
        }
        else {
            return helper(nums, target, mid+1, end) || helper(nums, target, start, mid-1);
        }
    }

    public boolean search2(int[] nums, int target) {
        if (nums==null || nums.length==0) return false;
        int start=0, end=nums.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (nums[mid]==target) return true;
            else if (nums[mid]>nums[start]){
                if (target>=nums[start] && target<nums[mid]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else if (nums[mid]<nums[start]){
                if (target>nums[mid] && target<=nums[end]){
                    start=mid+1;
                }
                else {
                    end=mid-1;
                }
            }
            else {
                start++;
            }
        }
        return false;
    }
}
