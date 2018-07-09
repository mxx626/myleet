package com.company;
// TAG: Two Pointer
public class MaxConsecutiveOnesII {
    /**
     * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

     Example 1:
     Input: [1,0,1,1,0]
     Output: 4
     Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
     After flipping, the maximum number of consecutive 1s is 4.
     Note:

     The input array will only contain 0 and 1.
     The length of input array is a positive integer and will not exceed 10,000
     Follow up:
     What if the input numbers come in one by one as an infinite stream? In other words, you can't store
     all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes1(int[] nums) {
        int res = 0;
        int prev=-1;
        int cur=-1;
        for (int j=0; j<nums.length; ++j){
            if (nums[j]==0){
                res = Math.max(res, j-prev-1);
                prev=cur;
                cur=j;
            }
        }
        return Math.max(res, nums.length-prev-1);
    }

    
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int used = 0;
        int i=0;
        for (int j=0; j<nums.length; ++j){
            if (nums[j]==0){
                if (used==1){
                    while (nums[i]!=0){
                        i++;
                    }
                    used=0;
                    i++;
                    j--;
                }
                else used=1;
            }
            if (j-i+1>res){
                res=j-i+1;
            }
        }
        return res;
    }
}
