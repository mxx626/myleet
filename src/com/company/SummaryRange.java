package com.company;
// TAG: Array, Two POinter
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SummaryRange {
    /**
     *  Given a sorted integer array without duplicates, return the summary of its ranges.

     Example 1:

     Input: [0,1,2,4,5,7]
     Output: ["0->2","4->5","7"]

     Example 2:

     Input: [0,2,3,4,6,8,9]
     Output: ["0","2->4","6","8->9"]

     Credits:
     Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        LinkedList<String> list = new LinkedList<>();
        if (nums==null || nums.length==0) return list;
        for (int i=0; i<nums.length; ++i){
            int cur = nums[i];
            while (i+1<nums.length && nums[i+1]==nums[i]+1) i++;
            if (cur !=nums[i]){
                list.add(cur + "->" + nums[i]);
            }
            else list.add(cur + "");
        }
        return list;
    }

    public class Array_SummaryRanges {
        public List<String> summaryRanges(int[] nums) {
            if (nums.length == 0 || nums == null) return new ArrayList<>();
            List<String> res = new ArrayList<>();
            if (nums.length == 1) {
                res.add(String.valueOf(nums[0]));
                return res;
            }
            int start = 0;
            for (int end = 0; end < nums.length; ++end) {
                if (end != nums.length - 1 && nums[end] + 1 == nums[end + 1]) {
                    continue;
                } else {
                    if (end == start) {
                        res.add(String.valueOf(nums[start]));
                    } else {
                        String word = nums[start] + "->" + nums[end];
                        res.add(word);
                    }
                    start = end + 1;
                }
            }
            return res;
        }
    }
}
