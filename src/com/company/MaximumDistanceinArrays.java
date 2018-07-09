package com.company;

import java.util.List;

// Arrays, HashTable
public class MaximumDistanceinArrays {
    /**
     * Given m arrays, and each array is sorted in ascending order. Now you can
     * pick up two integers from two different arrays (each array picks one) and
     * calculate the distance. We define the distance between two integers a and
     * b to be their absolute difference |a-b|. Your task is to find the maximum
     * distance.

     Example 1:
     Input:
     [[1,2,3],
     [4,5],
     [1,2,3]]
     Output: 4
     Explanation:
     One way to reach the maximum distance 4 is to pick 1 in the first or third
     array and pick 5 in the second array.
     Note:
     Each given array will have at least 1 number. There will be at least two non-empty arrays.
     The total number of the integers in all the m arrays will be in the range of [2, 10000].
     The integers in the m arrays will be in the range of [-10000, 10000].
     * @param arrays
     * @return
     */
    public int maxDistance(List<List<Integer>> arrays) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1Idx=-1, min2Idx=-1, max1Idx=-1, max2Idx=-1;

        for (int i=0; i<arrays.size(); ++i){
            int curMin = arrays.get(i).get(0);
            int curMax = arrays.get(i).get(arrays.get(i).size()-1);
            if (curMin < min1){
                min2=min1;
                min2Idx=min1Idx;
                min1=curMin;
                min1Idx=i;
            }
            else if (curMin<min2){
                min2=curMin;
                min2Idx=i;
            }

            if (curMax>max1){
                max2=max1;
                max2Idx=max1Idx;
                max1=curMax;
                max1Idx=i;
            }
            else if (curMax>max2){
                max2=curMax;
                max2Idx=i;
            }
        }
        if (min1Idx!=max1Idx) return max1-min1;
        return Math.max(max1-min2, max2-min1);
    }
}
