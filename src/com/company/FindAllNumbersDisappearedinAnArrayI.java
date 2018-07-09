package com.company;
// TAG: Array
import java.util.LinkedList;
import java.util.List;

public class FindAllNumbersDisappearedinAnArrayI {
    /**
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice
     * and others appear once.

     Find all the elements of [1, n] inclusive that do not appear in this array.

     Could you do it without extra space and in O(n) runtime? You may assume the returned list does
     not count as extra space.

     Example:

     Input:
     [4,3,2,7,8,2,3,1]

     Output:
     [5,6]

     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int n : nums){
            int idx = Math.abs(n)-1;
            if (nums[idx]<0) continue;
            nums[idx]=-nums[idx];
        }
        for (int i=0; i<nums.length; ++i){
            if (nums[i]>0)
                list.add(i+1);
        }
        return list;
    }
}
