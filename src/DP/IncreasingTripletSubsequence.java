package DP;
// DP
import java.util.Arrays;
public class IncreasingTripletSubsequence {
    /**
     * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

     Formally the function should:
     Return true if there exists i, j, k
     such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
     Your algorithm should run in O(n) time complexity and O(1) space complexity.

     Examples:
     Given [1, 2, 3, 4, 5],
     return true.

     Given [5, 4, 3, 2, 1],
     return false.

     Credits:
     Special thanks to @DjangoUnchained for adding this problem and creating all test cases.
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums==null || nums.length<3) return false;
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; ++i){
            if (nums[i]<=min) min = nums[i];
            else if (nums[i]<=mid) mid = nums[i];
            else return true;
        }
        return false;
    }


    public boolean increasingTriplet2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i=0; i<nums.length; ++i){
            for (int j=0; j<i; ++j){
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    if (dp[i]>=3) return true;
                }
            }
        }
        return false;
    }
}
