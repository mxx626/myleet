package com.company;
// TAG: Array, Backtracking
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the
 *  candidate numbers sums to T. Each number in C may only be used once in the combination.
 *
 *  Note:
 *  All numbers (including target) will be positive integers.
 *  The solution set must not contain duplicate combinations.
 *  For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 *  A solution set is:
 *  [
 *  [1, 7],
 *  [1, 2, 5],
 *  [2, 6],
 *  [1, 1, 6]
 *  ]
 * **/
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result, new ArrayList<>(), target, 0, candidates);
        return result;
    }
    public void helper (List<List<Integer>> result, List<Integer> sum, int target, int start, int[] candidates){
        if (target == 0){
            result.add(new ArrayList<>(sum));
        }
        else if (target < 0){
            return;
        }
        else {
            for (int i=start; i<candidates.length&&target-candidates[i]>=0; ++i){
                if (i>start && candidates[i-1]==candidates[i]) continue;
                sum.add(candidates[i]);
                helper(result, sum, target-candidates[i], i+1, candidates);
                sum.remove(sum.size()-1);
            }
        }
    }
}
