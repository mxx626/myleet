package com.company;

public class RemoveElement {
    /**
     * Given an array and a value, remove all instances of that value in-place and return the new length.

     Do not allocate extra space for another array, you must do this by modifying the input
     array in-place with O(1) extra memory.

     The order of elements can be changed. It doesn't matter what you leave beyond the new length.

     Example:

     Given nums = [3,2,2,3], val = 3,

     Your function should return length = 2, with the first two elements of nums being 2.
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        // ptr always point to the val in the nums.
        // and the ptr at the end of the non-val array
        int ptr=0, len=0;
        for (int i=0; i<nums.length; ++i){
            if (nums[i]!=val){
                nums[ptr++]=nums[i];
            }
        }
        return ptr;
    }

    //Two Pointer
    public int removeElement1(int[] nums, int val) {
        int left=0, right=nums.length-1;
        int len=nums.length;
        while (left<=right){
            if (nums[left]==val){
                while (left<right && nums[right]==val){
                    right--;
                    len--;
                }
                nums[left]=nums[right];
                right--;
                len--;
            }
            left++;
        }
        return len;
    }
}
