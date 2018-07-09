package com.company;

import java.util.Arrays;

/**
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array
 * that can make triangles if we take them as side lengths of a triangle.
 *
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 *
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 * **/
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count=0, length=nums.length;
        for (int i=0; i<length; ++i){
            for (int j=i+1; j<length; j++){
                int k=length-1;
                while (j<k){
                    if (isValid(nums[i], nums[j], nums[k])){
                        count+=k-j;
                        break;
                    }
                    else {
                        k--;
                        continue;
                    }
                }
            }
        }
        return count;
    }

    public boolean isValid (int len1, int len2, int len3){
        return ((len1+len2>len3)&&(len1+len3>len2)&&(len2+len3>len1));
    }
    //Solution 2: faster
    public int triangleNumber2(int[] nums) {
        int count=0;
        Arrays.sort(nums);
        for (int i=2; i<nums.length; ++i){
            //   if (nums[i]==0) continue;
            int j=0, k=i-1;
            while (j<k){
                if (nums[j]+nums[k]>nums[i]){
                    count += k-j;
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return count;
    }


}
