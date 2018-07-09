package com.company;
// Bit
/**
 * 137. Single Number II

 Given a non-empty array of integers, every element appears three times except for one,
 which appears exactly once. Find that single one.

 Note:

 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Example 1:

 Input: [2,2,3,2]
 Output: 3
 Example 2:

 Input: [0,1,0,1,0,1,99]
 Output: 99
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int a=0, b=0;
        for (int i : nums){
            a = (a^i)&(~b);
            b = (b^i)&(~a);
        }
        return a;
    }
}
