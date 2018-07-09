package com.company;
//TAG: Array, Two Pointer
/**
 *  Follow up for "Remove Duplicates":
 *  What if duplicates are allowed at most twice?
 *  For example,
 *  Given sorted array nums = [1,1,1,2,2,3],
 *  Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter
 *  what you leave beyond the new length.
 * **/
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int idx=0;
        for (int n : nums){
            if (idx<2 || n>nums[idx-2])
                nums[idx++]=n;
        }
        return idx;
    }
}
