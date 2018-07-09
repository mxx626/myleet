package DP;
// TAG: DP
public class NumberofLongestIncreasingSubsequence {
    /**
     * Given an unsorted array of integers, find the number of longest increasing subsequence.

     Example 1:
     Input: [1,3,5,4,7]
     Output: 2
     Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
     Example 2:
     Input: [2,2,2,2,2]
     Output: 5
     Explanation: The length of longest continuous increasing subsequence is 1, and there
     are 5 subsequences' length is 1, so output 5.
     Note: Length of the given array will be not exceed 2000 and the answer is guaranteed
     to be fit in 32-bit signed int.
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int len=nums.length;
        if (len==0) return 0;
        int[] _len = new int[len];
        int[] _cnt = new int[len];

        for (int i=0; i<len; ++i){
            _cnt[i]=1;
            for (int j=0; j<i; ++j){
                if (nums[j]<nums[i]){
                    if (_len[j]>=_len[i]){
                        _len[i]=_len[j]+1;
                        _cnt[i]=_cnt[j];
                    }
                    else if (_len[j]+1==_len[i]){
                        _cnt[i]+=_cnt[j];
                    }
                }
            }
        }

        int max=0;
        for (int alen : _len){
            max = Math.max(max, alen);
        }
        int res=0;
        for (int i=0; i<_cnt.length; ++i){
            if (_len[i]==max){
                res+=_cnt[i];
            }
        }
        return res;
    }
}
