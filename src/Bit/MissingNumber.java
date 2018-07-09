package Bit;
// Math, Bit
public class MissingNumber {
    /**
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

     Example 1:

     Input: [3,0,1]
     Output: 2
     Example 2:

     Input: [9,6,4,2,3,5,7,0,1]
     Output: 8
     Note:
     Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int sum = (int)(0+nums.length)*(1+nums.length)/2;
        for (int i : nums){
            sum -= i;
        }
        return sum;
    }

    public int missingNumber2(int[] nums) {
        int miss = nums.length;
        for (int i=0; i<nums.length; ++i){
            miss ^= i^nums[i];
        }
        return miss;
    }
}
