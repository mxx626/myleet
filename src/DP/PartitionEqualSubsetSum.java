package DP;
// DP, 0-1 kackpack
public class PartitionEqualSubsetSum {
    /**
     * Given a non-empty array containing only positive integers, find if the
     * array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

     Note:
     Each of the array element will not exceed 100.
     The array size will not exceed 200.
     Example 1:

     Input: [1, 5, 11, 5]

     Output: true

     Explanation: The array can be partitioned as [1, 5, 5] and [11].
     Example 2:

     Input: [1, 2, 3, 5]

     Output: false

     Explanation: The array cannot be partitioned into equal sum subsets.
     */
    private boolean[] dp=null;
    public boolean canPartition(int[] nums) {
        int sum=0, len=nums.length;
        for (int n : nums) sum+=n;
        if (sum%2==1) return false;
        int length=sum/2+1;
        dp = new boolean[length];
        dp[0]=true;
        for (int n : nums){
            for (int i=sum/2; i>=n; --i){
                if (dp[i]) break;
                dp[i]=dp[i-n];
            }
            if(dp[sum/2]) return true;
        }
        return dp[sum/2];
    }
}
