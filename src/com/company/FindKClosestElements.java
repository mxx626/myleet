package com.company;

import java.util.*;

public class FindKClosestElements {
    /**
     * Given a sorted array, two integers k and x, find the k closest elements to x in the array.
     * The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

     Example 1:

     Input: [1,2,3,4,5], k=4, x=3
     Output: [1,2,3,4]

     Example 2:

     Input: [1,2,3,4,5], k=4, x=-1
     Output: [1,2,3,4]

     Note:

     The value k is positive and will always be smaller than the length of the sorted array.
     Length of the given array is positive and will not exceed 104
     Absolute value of elements in the array and x will not exceed 104

     UPDATE (2017/9/19):
     The arr parameter had been changed to an array of integers (instead of a list of integers). Please
     reload the code definition to get the latest changes.
     * **/
    /**
     * max lowerbound must be in the N-k;
     * thus the search range is from 0 -> N-k;
     * if x < mid, lower bound must be in 0 -> mid
     * if x > mid, lower bound could in 0 - N-k;
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start=0, end=arr.length-k;
        while (start<end){
            int mid = start+(end-start)/2;
            if (x-arr[mid]>arr[mid+k]-x){
                start=mid+1;
            }
            else end=mid;
        }
        List<Integer> list = new ArrayList<>();
        for (int i=start; i<start+k; ++i){
            list.add(arr[i]);
        }
        return list;
    }


    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> res = new LinkedList<>();
        int idx = binarySearch(arr, x);
        //   System.out.println(idx);
        int i=idx-1, j=idx;
        while (k!=0){
            if (i<0) res.add(arr[j++]);
            else if (j>arr.length-1) res.add(arr[i--]);
            else {
                if (x-arr[i]>arr[j]-x) {
                    res.add(arr[j++]);
                }
                else res.add(arr[i--]);
            }
            k--;
        }
        Collections.sort(res);
        return res;

    }
    private int binarySearch(int[] arr, int k){
        int i=0, j=arr.length-1;
        while (i<=j){
            int m = i+(j-i)/2;
            if (arr[m]==k) return m;
            else if (arr[m]>k){
                j=m-1;
            }
            else i=m+1;
        }
        return i;
    }
}
