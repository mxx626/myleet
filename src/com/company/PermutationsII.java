package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example, [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * **/
public class PermutationsII {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        DFS(new ArrayList<>(), nums, new int[nums.length]);
        return res;
    }
    public void DFS(List<Integer> list, int[] num, int[] visit){
        if (list.size()==num.length){
            res.add(new ArrayList<>(list));
        }
        else {
            for (int i=0; i<num.length; ++i){
                if (visit[i]==1) continue;
                if (i>0 && num[i-1]==num[i] && visit[i-1]==0) continue;
                list.add(num[i]);
                visit[i]=1;
                DFS(list, num, visit);
                visit[i]=0;
                list.remove(list.size()-1);
            }
        }
    }
}
