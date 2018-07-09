package DP;
// DP
import java.util.Arrays;
public class CombinationSumIV {
    /**
     * Given an integer array with all positive numbers and no duplicates, find the number of possible
     * combinations that add up to a positive integer target.

     Example:

     nums = [1, 2, 3]
     target = 4

     The possible combination ways are:
     (1, 1, 1, 1)
     (1, 1, 2)
     (1, 2, 1)
     (1, 3)
     (2, 1, 1)
     (2, 2)
     (3, 1)

     Note that different sequences are counted as different combinations.

     Therefore the output is 7.
     Follow up:
     What if negative numbers are allowed in the given array?
     How does it change the problem?
     What limitation we need to add to the question to allow negative numbers?
     */
    private int[] dp = null;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0]=1;
        return helper(nums, target);
    }
    private int helper(int[] nums, int target){
        if (dp[target]!=-1){
            return dp[target];
        }
        int res = 0;
        for (int i=0; i<nums.length; ++i){
            if (target>=nums[i]){
                res += helper(nums, target-nums[i]);
            }
        }
        dp[target]=res;
        return res;
    }




    private int count = 0;
    public int combinationSum42(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target+1];
        dp[0]=1;
        for (int i=1; i<=target; ++i){
            for (int n : nums){
                if (n>i) break;
                dp[i] += dp[i-n];
            }
        }
        return dp[target];
    }



}
