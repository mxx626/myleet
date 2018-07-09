package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *  Note: The solution set must not contain duplicate subsets.
 *  For example,
 *  If nums = [1,2,2], a solution is:
 *  [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 *  ]

 * **/
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start){
        res.add(new ArrayList<>(list));
        for (int i=start; i<nums.length; ++i){
            if (i!=start && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            helper(res, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}
