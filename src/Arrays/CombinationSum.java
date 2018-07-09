package Arrays;
// TAG: Arrays, Backtracking
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class CombinationSum {
    /**
     * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
     * find all unique combinations in C where the candidate numbers sums to T.

     The same repeated number may be chosen from C unlimited number of times.

     Note:
     All numbers (including target) will be positive integers.
     The solution set must not contain duplicate combinations.
     For example, given candidate set [2, 3, 6, 7] and target 7,
     A solution set is:
     [
     [7],
     [2, 2, 3]
     ]
     */
    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, 0, new LinkedList<>(), target);
        return res;
    }

    private void helper(int[] nums, int i, LinkedList<Integer> list, int target){
        if (target==0){
            res.add(new LinkedList<>(list));
            return;
        }
        else if (target<0) return;
        for (int x=i; x<nums.length; ++x){
            list.offer(nums[x]);
            helper(nums, x, list, target-nums[x]);
            list.pollLast();
        }
    }
}
