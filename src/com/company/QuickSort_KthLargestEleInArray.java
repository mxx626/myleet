package com.company;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 *              3   2   1   5   6   4
 *                  l               r
 *              3   4   1   5   6   2
 *                      l       r
 *              3   4   6   5   1   2
 *                          l
 *                          r
 *              3   4   6   5   1   2
 *                              l
 *                          r
 *
 **/
public class QuickSort_KthLargestEleInArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums==null || nums.length==0) return 0;
        int left = 0, right = nums.length-1;
        while (true){
            int position = partition(nums, left, right);
            if (position+1==k){
                return nums[position];
            }
            else if (position+1<k){
                left = position+1;
            }
            else {
                right = position-1;
            }
        }
    }

    public int partition (int[] arr, int left, int right){
        int pivot = arr[left];
        int l = left+1;
        int r = right;
        while (l<=r){
            if (arr[l]<pivot && arr[r]>pivot){
                swap(arr, l, r);
                l++;
                r--;
            }
            if (arr[l]>=pivot) l++;
            if (arr[r]<=pivot) r--;
        }
        swap(arr, left, r);
        return r;
    }

    public void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }

    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<nums.length; i++){
            pq.offer(nums[i]);
            if (pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}
