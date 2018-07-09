package com.company;
// TAG: Array, Backtracking
import java.util.ArrayList;
import java.util.List;

/**
 *Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used
 * and each combination should be a unique set of numbers.
 *
 * Example 1:
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 *
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]

 * **/
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), k, 1, n);
        return res;
    }
    private void helper (List<List<Integer>> res, List<Integer> list, int num, int start, int target){
        if (num==0 && target==0){
            res.add(new ArrayList<>(list));
        }
        else if (num==0 || target<=0) return;
        else{
            for (int i=start; i<=9; ++i){
                list.add(i);
                helper(res,list,num-1,i+1, target-i);
                list.remove(list.size()-1);
            }
        }
    }
}
