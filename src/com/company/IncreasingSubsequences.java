package com.company;
// DFS, Backtracking
import java.util.*;

public class IncreasingSubsequences {
    /**
     * Given an integer array, your task is to find all the different possible
     * increasing subsequences of the given array, and the length of an increasing
     * subsequence should be at least 2 .

     Example:
     Input: [4, 6, 7, 7]
     Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
     Note:
     The length of the given array will not exceed 15.
     The range of integer in the given array is [-100,100].
     The given array may contain duplicates, and two equal integers should also
     be considered as a special case of increasing sequence.
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        helper(nums, 0, res, new LinkedList<>());
        return new ArrayList<>(res);
    }
    private void helper(int[] nums, int start, Set<List<Integer>> res, LinkedList<Integer> list){
        if (list.size()>1){
            res.add(new ArrayList<>(list));
        }
        if (start==nums.length) return;
        Set<Integer> visit=new HashSet<>();

        for (int i=start; i<nums.length; ++i){
            if (!visit.add(nums[i])) continue;
            if  (list.size()==0 || list.getLast()<=nums[i]){
                list.offer(nums[i]);
                helper(nums, i+1, res, list);
                list.removeLast();
            }
        }
    }
}
