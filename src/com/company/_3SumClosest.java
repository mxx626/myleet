package com.company;
// TAG: Arrays, Two Pointer
import java.util.Arrays;

public class _3SumClosest {
    /**
     * Given an array S of n integers, find three integers in S such that the sum is
     * closest to a given number, target. Return the sum of the three integers. You
     * may assume that each input would have exactly one solution.

     For example, given array S = {-1 2 1 -4}, and target = 1.

     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int diff=Integer.MAX_VALUE, res=0;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; ++i){
            if (i==0 || (i!=0 && nums[i]!=nums[i-1])){
                int j=i+1, k=nums.length-1;
                while (j<k){
                    int sum = nums[i]+nums[j]+nums[k];
                    if (sum==target) return target;
                    else if (sum<target){
                        if ((target-sum)<diff){
                            diff=target-sum;
                            res=sum;
                        }
                        j++;
                        while (j<k && nums[j]==nums[j-1]) j++;
                    }
                    else {
                        if ((sum-target)<diff){
                            diff=sum-target;
                            res=sum;
                        }
                        k--;
                        while (j<k && k!=nums.length-1 && nums[k]==nums[k+1]) k--;
                    }
                }
            }
        }
        return res;
    }
}
