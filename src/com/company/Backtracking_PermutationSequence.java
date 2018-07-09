package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *          1   2   3   4   5
 *          1   1   2   6   24
 *
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive
 * **/
public class Backtracking_PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> permutation = new ArrayList<>();
        for (int i=1; i<=n; ++i){
            permutation.add(i);
        }
        int[] factory = new int[n];
        factory[0]=1;
        k--;
        for (int i=1; i<n; ++i){
            factory[i]=i*factory[i-1];  //formula is the key, because every time you have found the number, you need to
                                        //confirm the next number, which have the permutation numebr which store in the factory[i-1]
        }
        for (int i=n; i>=1; --i){
            int idx = k/factory[i-1];
            k = k%factory[i-1];
            sb.append(permutation.get(idx));
            permutation.remove(idx);
        }
        return sb.toString();
    }
}
