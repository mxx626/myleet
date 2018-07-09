package com.company;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    /**
     * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
     * Example 1:
     * Input: [0,1]
     * Output: 2
     * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
     *
     * Example 2:
     * Input: [0,1,0]
     * Output: 2
     * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
     * Note: The length of the given binary array will not exceed 50,000.
     *      0   0   0   1   1   1   1   0   1   0   1   1   0
     *      1   2   3   3   3   3   3   4   4   5   5   5   6
     *      0   0   0   1   2   3   4   4   5   5   6   7   8
     */
    public int findMaxLength(int[] nums) {
        if (nums==null || nums.length==0 || nums.length==1) return 0;
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<nums.length; ++i){
            sum+=(nums[i]<<1) - 1;
            if (map.containsKey(sum)){
                res = Math.max(res, i-map.get(sum));
            }
            else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
