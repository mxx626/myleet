package Backtracking;
// Backtracking
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    private List<List<Integer>> ret = new ArrayList<>();

    /**
     * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

     Example:

     Input: [1,1,2]
     Output:
     [
     [1,1,2],
     [1,2,1],
     [2,1,1]
     ]
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] visit = new int[nums.length];
        helper(nums, new ArrayList<>(), visit);
        return ret;
    }
    private void helper(int[] nums, List<Integer> list, int[] visit){
        if (list.size()==nums.length){
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i=0; i<nums.length; ++i){
            if (visit[i]==-1) continue;
            if (i!=0 && nums[i]==nums[i-1] && visit[i-1]==-1 ) continue;
            list.add(nums[i]);
            visit[i]=-1;
            helper(nums, list, visit);
            visit[i]=0;
            list.remove(list.size()-1);
        }
    }
}
