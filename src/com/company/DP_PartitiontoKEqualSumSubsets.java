package com.company;

import java.util.Arrays;

public class DP_PartitiontoKEqualSumSubsets {
    /**
     * Given an array of integers nums and a positive integer k, find whether it's possible
     * to divide this array into k non-empty subsets whose sums are all equal.
     *
     * Example 1:
     * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
     * Output: True
     * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
     *
     * Note:
     * 1 <= k <= len(nums) <= 16.
     * 0 < nums[i] < 10000.
     * **/
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for (int num : nums) sum+=num;
        if (sum%k!=0 || k<=0) return false;
        int subSum = sum/k;
        int visit[] = new int[nums.length];
        return helper(k, nums, 0, 0, subSum, visit);
    }
    public boolean helper (int k, int[] nums, int startIdx, int subSum, int target, int[] visit){
        if (k==1) return true;
        if (subSum==target) {
            return helper(k-1, nums, 0, 0, target, visit);
        }
        for (int i=startIdx; i<nums.length; ++i){
            if (visit[i]==0 && subSum+nums[i]<=target) {
                visit[i]=1;
                if (helper(k, nums, i+1, subSum+nums[i], target, visit)){
                    return true;
                }
                visit[i]=0;
            }
        }
        return false;
    }


    //Solution 2
    boolean[] visited;
    public boolean canPartitionKSubsets2(int[] nums, int k) {
        int sum=0;
        for(int i: nums) sum += i;
        if (k<=0 || sum%k!=0) return false;
        int target  = sum/k;
        visited = new boolean[nums.length];

        return canPart(nums, 0, k, target, 0);
    }

    private boolean canPart(int[] nums, int cum, int k, int target, int start_index) {
        if (k==0) return true;
        if (cum == target) return canPart(nums, 0, k-1, target, 0);
        for(int i=start_index; i<nums.length; i++) {
            if (! visited[i] && nums[i] + cum <= target) {
                visited[i] = true;
                boolean bok = canPart(nums, nums[i]+cum, k, target, i+1);
                if (bok) return true;

                visited[i] = false;
            }
        }

        return false;
    }
}
