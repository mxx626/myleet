package Arrays;
// TAG: Arrays, Backtracking
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSumII {
    /**
     * Given a collection of candidate numbers (C) and a target number (T), find all unique
     * combinations in C where the candidate numbers sums to T.

     Each number in C may only be used once in the combination.

     Note:
     All numbers (including target) will be positive integers.
     The solution set must not contain duplicate combinations.
     For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
     A solution set is:
     [
     [1, 7],
     [1, 2, 5],
     [2, 6],
     [1, 1, 6]
     ]
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, list, res);
        return res;
    }
    private void helper(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> res){
        if (target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        else if (target<0){
            return;
        }
        for (int i=start; i<candidates.length&&target-candidates[i]>=0; ++i){
            if (i!=start && candidates[i]==candidates[i-1]) continue;
            list.add(candidates[i]);
            helper(candidates, target-candidates[i], i+1, list, res);
            list.remove(list.size()-1);
        }
    }
}
