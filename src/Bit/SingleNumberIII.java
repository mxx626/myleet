package Bit;
// Bit
/**
 * 260. Single Number III

 Given an array of numbers nums, in which exactly two elements appear only once and
 all the other elements appear exactly twice. Find the two elements that appear only once.

 Example:

 Input:  [1,2,1,3,2,5]
 Output: [3,5]
 Note:

 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i=1; i<nums.length; ++i) xor ^= nums[i];
        int groupBit = xor & (~(xor-1));
        int num1=0;
        int num2=0;
        for (int num : nums){
            if ((num & groupBit)>0){
                num1 ^= num;
            }
            else num2 ^= num;
        }
        int[] res = new int[2];
        res[0]=num1;
        res[1]=num2;
        return res;
    }
}
