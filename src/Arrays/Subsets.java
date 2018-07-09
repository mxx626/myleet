package Arrays;
// TAG: Array, Backtracking
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    /**
     * Given a set of distinct integers, nums, return all possible subsets (the power set).

     Note: The solution set must not contain duplicate subsets.

     For example,
     If nums = [1,2,3], a solution is:

     [
     [3],
     [1],
     [2],
     [1,2,3],
     [1,3],
     [2,3],
     [1,2],
     []
     ]
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res  = new LinkedList<>();
        helper(nums, 0, new LinkedList<>(), res);
        return res;
    }
    private void helper(int[] nums, int start, LinkedList<Integer> list, List<List<Integer>>res){
        res.add(new LinkedList<>(list));
        for (int i=start; i<nums.length; ++i){
            list.add(nums[i]);
            helper(nums, i+1, list,res);
            list.pollLast();
        }
    }
}
