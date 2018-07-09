package com.company;

import java.util.Arrays;

public class Bit_SingleNumberII {
    /**
     * Given an array of integers, every element appears three times except for one,
     * which appears exactly once. Find that single one.
     * Note:
     * Your algorithm should have a linear runtime complexity. Could you implement
     * it without using extra memory?
     * 00 -> 10 -> 01 -> 00
     * 1112
     *
     * one  0001
     * two  0000  record in one
     *
     * one  0000
     * two  0001  move to two
     *
     * one  0000
     * two  0000  clear
     * Thus when we meet number with 3 times frequency, we will always eliminate the number
     * except the one which only have one time frequency.
     *
     */
    public int singleNumber(int[] nums) {
        int one=0, two=0;
        for (int i=0; i<nums.length; ++i){
            one = (one ^ nums[i]) & ~two;
            two = (two ^ nums[i]) & ~one;
        }
        return one;
    }

    public int singleNumber1(int[] nums) {
        if (nums.length==1) return nums[0];
        int res=0;
        Arrays.sort(nums);
        for (int i=0; i<nums.length; ++i){
            if (i==0 && nums[i]!= nums[i+1]) return nums[i];
            if (i==nums.length-1 && nums[i]!=nums[i-1]) return nums[i];
            if (i!=0 && i!=nums.length-1 && nums[i]!=nums[i-1] && nums[i]!=nums[i+1]){
                res=nums[i];
            }
        }
        return res;
    }
}
