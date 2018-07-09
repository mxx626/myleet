package com.company;
// Divide and Conquer, Heap
public class KthLargestElementinanArray {
    /**
     * Find the kth largest element in an unsorted array. Note that it is the kth
     * largest element in the sorted order, not the kth distinct element.

     Example 1:

     Input: [3,2,1,5,6,4] and k = 2
     Output: 5
     Example 2:

     Input: [3,2,3,1,2,4,5,5,6] and k = 4
     Output: 4
     Note:
     You may assume k is always valid, 1 ≤ k ≤ array's length.
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int p = quickSelection(nums, 0, nums.length-1, k);
        return nums[p];
    }
    private int quickSelection(int[] nums, int s, int e, int k)
    {
        int i = s-1;
        int pivot = nums[e];
        for (int j = s; j<e; ++j)
        {
            if (nums[j]>=pivot)
            {
                i++;
                int tmp = nums[j];
                nums[j]=nums[i];
                nums[i]=tmp;
            }
        }
        int tmp1 = nums[++i];
        nums[i]= nums[e];
        nums[e] = tmp1;

        int m = i-s+1;
        if (m==k) return i;
        if (m>k) return quickSelection(nums, s, i-1, k);
        else return quickSelection(nums, i+1, e, k-m);
    }
}
