package com.company;
/**
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 *
 Example 1:
 Input: [1,3,5,4,7]
 Output: 2
 Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].

 Example 2:
 Input: [2,2,2,2,2]
 Output: 5
 Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.

 Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 *
 * dp[i]=max(dp[j]+1, dp[i])_
 *
 *        10   9    2   6     4    3   5       101    18
 *         1   1    1   2     2    2   3         4     4
 *         1   1    1   2     2    2
 *
 *    [2,3,7,101]  [2,3,7,18]
 **/

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int res=0,number=0;
        for (int i=0; i<nums.length; ++i) {
            count[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[j]>=dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    else if (dp[j]+1==dp[i]){
                        count[i]+=count[j];
                    }
                }
            }
        }
        for (int longest : dp){
            res = Math.max(res, longest);
        }
        for (int i=0; i<nums.length; i++){
            if (dp[i]==res){
                number+=count[i];
            }
        }
        return number;
    }
}
