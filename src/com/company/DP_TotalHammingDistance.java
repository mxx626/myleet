package com.company;

import java.util.Arrays;

public class DP_TotalHammingDistance {
    /**
     * The Hamming distance between two integers is the number of positions at which the
     * corresponding bits are different.

     Now your job is to find the total Hamming distance between all pairs of the given numbers.

     Example:

     Input: 4, 14, 2

     Output: 6

     Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
     showing the four bits relevant in this case). So the answer will be:
     HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

     Note:

     Elements of the given array are in the range of 0 to 10^9
     Length of the array will not exceed 10^4.

     * @param nums
     * @return
     */
    //slow, slow, slow
    public int totalHammingDistance(int[] nums) {
        int sum=0;
        for (int i=0; i<nums.length; ++i){
            for (int j=0; j<i; ++j){
                sum+=Integer.bitCount(nums[i]^nums[j]);
            }
        }
        return sum;
    }
    public int totalHammingDistance2(int[] nums){
        if (nums==null || nums.length==0) return 0;
        int max=0;
        for (int i=0; i<nums.length; ++i){
            if (nums[i]>nums[max])
                max=i;
        }
        int len=nums.length;
        int sum=0;
        while (nums[max]>0){
            int count=0;
            for (int i=0; i<nums.length; ++i){
                if (nums[i]%2==1){
                    count++;
                }
                nums[i] >>= 1;
            }
            sum += count*(len-count);
        }
        return sum;
    }
    public int totalHammingDistance3 (int[] nums){
        if (nums==null || nums.length==0) return 0;
        int total=0;
        for (int i=0; i<32; ++i){
            int count=0;
            for (int j=0; j<nums.length; ++j){
                count += (nums[j]>>i)&1;
            }
            total+=count*(nums.length-count);
        }
        return total;
    }
}
