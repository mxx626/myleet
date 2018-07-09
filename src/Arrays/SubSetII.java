package Arrays;
// TAG: Array, Backtracking
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class SubSetII {
    /**
     * Given a collection of integers that might contain duplicates, nums, return
     * all possible subsets (the power set).

     Note: The solution set must not contain duplicate subsets.

     For example,
     If nums = [1,2,2], a solution is:

     [
     [2],
     [1],
     [1,2,2],
     [2,2],
     [1,2],
     []
     ]

     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null) return res;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, list, 0, nums);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int start, int[] nums){
        res.add(new ArrayList<>(list));
        for (int i=start; i<nums.length; ++i){
            if (i!=start && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            helper(res, list, i+1, nums);
            list.remove(list.size()-1);
        }
    }
}
