package com.company;
// Sort

import java.util.HashSet;
import java.util.Set;

/**
 * 575. Distribute Candies

 Given an integer array with even length, where different numbers in this array represent
 different kinds of candies. Each number means one candy of the corresponding kind. You need
 to distribute these candies equally in number to brother and sister. Return the maximum
 number of kinds of candies the sister could gain.
 Example 1:
 Input: candies = [1,1,2,2,3,3]
 Output: 3
 Explanation:
 There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 The sister has three different kinds of candies.
 Example 2:
 Input: candies = [1,1,2,3]
 Output: 2
 Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 The sister has two different kinds of candies, the brother has only one kind of candies.
 Note:

 The length of the given array is in range [2, 10,000], and will be even.
 The number in given array is in range [-100,000, 100,000].
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int i : candies) set.add(i);
        return Math.min(set.size(), candies.length/2);
    }

    public int distributeCandies2(int[] candies) {
        quickSort(candies, 0, candies.length-1);
        int count=1;
        for (int i=1; i<candies.length && count<candies.length/2; ++i){
            if (candies[i]>candies[i-1]) count++;
        }
        return count;
    }
    private void quickSort(int[] arr, int s, int e){
        if (s>=e) return;
        int pivot = arr[e];
        int ptr = s-1;
        for (int i=s; i<e; ++i){
            if (arr[i]<pivot){
                ptr++;
                int tmp = arr[i];
                arr[i] = arr[ptr];
                arr[ptr] = tmp;
            }
        }
        int num = arr[++ptr];
        arr[ptr] = pivot;
        arr[e] = num;
        quickSort(arr, s, ptr-1);
        quickSort(arr, ptr+1, e);
    }
}
