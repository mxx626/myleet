package BinarySearch;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0]=1;
        int max=1;
        for (int i=1; i<nums.length; ++i){
            for (int j=0; j<i; ++j){
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
            max=Math.max(max, dp[i]);
        }
        return max;
    }


    public int lengthOfLIS2(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int len = 0;
        int[] dp = new int[nums.length];
        dp[len++]=nums[0];
        for (int i=1; i<nums.length; ++i){
            if (nums[i]<dp[0]) dp[0] = nums[i];
            else if (nums[i]>dp[len-1]){
                dp[len++]=nums[i];
            }
            else {
                int idx = binary (dp, 0, len-1, nums[i]);
                dp[idx]=nums[i];
            }
        }
        return len;
    }

    private int binary(int[] nums, int start, int end, int k){
        while (start<=end){
            int mid=start+(end-start)/2;
            if (nums[mid]==k) return mid;
            else if (nums[mid]>k){
                end=mid-1;
            }
            else start=mid+1;
        }
        return start;
    }
}
