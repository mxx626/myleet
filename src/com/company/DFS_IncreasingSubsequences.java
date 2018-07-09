package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFS_IncreasingSubsequences {
    /**
     * Given an integer array, your task is to find all the different possible increasing subsequences of
     * the given array, and the length of an increasing subsequence should be at least 2 .
     *
     * Example:
     Input: [4, 6, 7, 7]
     Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]

     Note:
     The length of the given array will not exceed 15.
     The range of integer in the given array is [-100,100].
     The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
     **/
    private Set<List<Integer>> ret;
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums==null || nums.length==0) return new ArrayList<>();
        ret = new HashSet<>();
        DFS(nums, 0, new ArrayList<>());
        return  new ArrayList<>(ret);
    }
    private void DFS(int[] nums, int start, List<Integer> list){
        if (list.size()>1){
            ret.add(new ArrayList<>(list));
        }
        for (int i=start; i<nums.length; ++i){
            if (list.size()==0 || nums[i]>=list.get(list.size()-1)){
                list.add(nums[i]);
                DFS(nums, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
    //SOlution2
    private void DFS2(int[] nums, int start, List<Integer> list, int min){
        byte[] visited = new byte[201];
        for (int i=start; i<nums.length; i++){
            if (nums[i]>=min && visited[nums[i]+100]!=1 ){
                visited[nums[i]+100]=1;
                list.add(nums[i]);
                if (list.size()>1) ret.add(new ArrayList<>(list));
                DFS2(nums, i+1, list, nums[i]);
                list.remove(list.size()-1);
            }
        }
    }
}
