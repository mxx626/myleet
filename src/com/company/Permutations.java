package com.company;
// Backtracking
import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /**
     * Given a collection of distinct integers, return all possible permutations.

     Example:

     Input: [1,2,3]
     Output:
     [
     [1,2,3],
     [1,3,2],
     [2,1,3],
     [2,3,1],
     [3,1,2],
     [3,2,1]
     ]

     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(nums, new ArrayList<>(), ret);
        return ret;
    }
    private void helper(int[] nums, List<Integer> list, List<List<Integer>> ret){
        if (list.size()==nums.length){
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i=0; i<nums.length; ++i){
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(nums, list, ret);
            list.remove(list.size()-1);
        }
    }
}
