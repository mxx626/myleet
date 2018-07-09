package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C
 *  where the candidate numbers sums to T.
 *  The same repeated number may be chosen from C unlimited number of times.
 *
 *  Note:
 *  All numbers (including target) will be positive integers.
 *  The solution set must not contain duplicate combinations.
 *  For example, given candidate set [2, 3, 6, 7] and target 7,
 *  A solution set is:
 *  [
 *  [7],
 *  [2, 2, 3]
 *  ]
 * **/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, 0, new ArrayList<Integer>(), result);
        return result;
    }
    public void helper (int[] candidates, int start, int target, int sum, List<Integer> list, List<List<Integer>> result){
        if (sum==target){
            //   Collections.sort(list);
            //   if (!result.contains(list)){
            result.add(new ArrayList<>(list));
            //}
        }
        else if (target<sum){
            return;
        }
        else {
            for (int i=start; i<candidates.length; i++){
                sum+=candidates[i];
                list.add(candidates[i]);
                helper(candidates, i, target, sum, list, result);
                sum-=candidates[i];
                list.remove(list.size()-1);
            }
        }
    }
}
