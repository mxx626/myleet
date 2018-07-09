package com.company;
// TAG: Array, Two Pointer
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {
    /**
     * Given an array S of n integers, are there elements a, b, c in S such
     * that a + b + c = 0? Find all unique triplets in the array which gives
     * the sum of zero.

     Note: The solution set must not contain duplicate triplets.

     For example, given array S = [-1, 0, 1, 2, -1, -4],

     A solution set is:
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]

     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums==null || nums.length<3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<nums.length-2; ++i){
            if (nums[i]>0) break;
            if (i!=0 && nums[i]==nums[i-1]) continue;
            int j=i+1, k=nums.length-1;
            while (j<k){
                if (nums[i]+nums[j]+nums[k]==0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++; k--;
                    while (j<k && nums[j]==nums[j-1]) j++;
                    while (j<k && k!=nums.length-1 && nums[k]==nums[k+1]) k--;
                }
                else if (nums[i]+nums[j]+nums[k]>0){
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return res;
    }

    //
    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums==null || nums.length<3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<nums.length-2; ++i){
            if (nums[i]>0) break;
            if (i!=0 && nums[i]==nums[i-1]) continue;
            int j=i+1, k=nums.length-1;
            while (j<k){
                if (nums[i]+nums[j]+nums[k]==0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++; k--;
                    while (j<k && nums[j]==nums[j-1]) j++;
                    while (j<k && k!=nums.length-1 && nums[k]==nums[k+1]) k--;
                }
                else if (nums[i]+nums[j]+nums[k]>0){
                    k--;
                    while (j<k && k!=nums.length-1 && nums[k]==nums[k+1]) k--;
                }
                else {
                    j++;
                    while (j<k && nums[j]==nums[j-1]) j++;
                }
            }
        }
        return res;
    }

}
