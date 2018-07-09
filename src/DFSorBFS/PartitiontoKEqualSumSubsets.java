package DFSorBFS;
// DFS
public class PartitiontoKEqualSumSubsets {
    /**
     * Given an array of integers nums and a positive integer k, find whether it's
     * possible to divide this array into k non-empty subsets whose sums are all equal.

     Example 1:
     Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
     Output: True
     Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
     Note:

     1 <= k <= len(nums) <= 16.
     0 < nums[i] < 10000.
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum%k!=0) return false;
        boolean[] visit = new boolean[nums.length];
        return dfs(nums, k, 0, 0, visit, sum/k, 0);
    }

    private boolean dfs(int[] nums, int k, int count, int start, boolean[] visit, int target, int sum){
        if (count == k) return true;
        if (sum==target){
            return dfs(nums, k, count+1, 0, visit, target, 0);
        }
        for (int i=start; i<nums.length; ++i){
            if (!visit[i] && sum+nums[i]<=target){
                visit[i]=true;
                if (dfs(nums, k, count, i+1, visit, target, sum+nums[i])) return true;
                visit[i]=false;
            }
        }
        return false;
    }
}
