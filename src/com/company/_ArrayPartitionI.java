package com.company;

import java.util.Arrays;

// TAG: Array
public class _ArrayPartitionI {
    /**
     *
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for (int i=0; i<nums.length; i=i+2){
            sum += nums[i];
        }
        return sum;
    }

    public int arrayPairSum2(int[] nums) {
        int[] count = new int[20001];
        int sum=0;
        for (int num : nums){
            count[num+10000]++;
        }
        int flag=1;
        for (int i=0; i<count.length; ++i){
            while (count[i]>0){
                if (flag>0){
                    sum+=i-10000;
                }
                count[i]--;
                flag=-flag;
            }
        }
        return sum;
    }
}
