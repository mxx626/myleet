package com.company;

import java.util.Arrays;
import java.util.Comparator;

// TAG: Array
public class LargestNumberAtLeastTwiceofOthers {
    /**
     * In a given integer array nums, there is always exactly one largest element.

     Find whether the largest element in the array is at least twice as much as every other number in the array.

     If it is, return the index of the largest element, otherwise return -1.

     Example 1:

     Input: nums = [3, 6, 1, 0]
     Output: 1
     Explanation: 6 is the largest integer, and for every other number in the array x,
     6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.



     Example 2:

     Input: nums = [1, 2, 3, 4]
     Output: -1
     Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.



     Note:

     nums will have a length in the range [1, 50].
     Every nums[i] will be an integer in the range [0, 99].

     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        if (nums.length==1) return 0;
        int firstIdx=0, secondIdx=0;
        int first = Integer.MIN_VALUE, second=Integer.MIN_VALUE;
        for (int i=0; i<nums.length; ++i){
            if (nums[i]==first || nums[i]==second) continue;
            if (nums[i]>first){
                second=first;
                first=nums[i];
                secondIdx=firstIdx;
                firstIdx=i;
            }
            else if (nums[i]>second){
                second=nums[i];
                secondIdx=i;
            }
        }
        return (second*2 <= first) ? firstIdx : -1;
    }

    public int dominantIndex2(int[] nums) {
        if (nums.length==1) return 0;
        Integer[] index = new Integer[nums.length];
        for (int i=0; i<nums.length; ++i){
            index[i]=i;
        }
        Arrays.sort(index, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return nums[o2]-nums[o1];
            }
        });

        return nums[index[0]]>=nums[index[1]]*2 ? index[0] : -1;
    }
}
