package com.company;
/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 * Example:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 *
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 * **/
public class BIT_RangeSumQuery_Mutable {
    private int[] anums;
    private int[] tree;
    public BIT_RangeSumQuery_Mutable(int[] nums) {
        if (nums.length ==  0 || nums == null) return;
        int len = nums.length;
        anums = new int[len];
        tree = new int[len+1];
        for (int i = 0; i < anums.length; i++){
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        if (anums.length==0) return;
        int diff = val - anums[i];
        anums[i] = val;
        for (int j = i+1; j <= anums.length; j += (j & (-j))){
            tree[j]+=diff;
        }
    }

    public int sumRange(int i, int j) {
        return sum(j+1) - sum(i);
    }

    public int sum (int idx){
        int sum=0;
        for (int i = idx; i > 0; i -= (i & (-i))){
            sum += tree[i];
        }
        return sum;
    }
}
