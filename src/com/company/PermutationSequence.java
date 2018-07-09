package com.company;
// Backtracking
/**
 * 60. Permutation Sequence
 *
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note:

 Given n will be between 1 and 9 inclusive.
 Given k will be between 1 and n! inclusive.
 Example 1:

 Input: n = 3, k = 3
 Output: "213"
 Example 2:

 Input: n = 4, k = 9
 Output: "2314"

 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        boolean[] visit = new boolean[n+1];
        int prod = 1;
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n-1; ++i) prod*=i;
        int c = n-1;
        while (k>0 && c>0){
            int count = prod;
            prod /= c--;
            int pos = (k-1)/count;
            k -= pos*count;
            for (int i=1; i<=n; ++i){
                if (!visit[i]){
                    if (pos>0) pos--;
                    else if (pos==0){
                        visit[i]=true;
                        sb.append(i);
                        break;
                    }
                }
            }
        }
        for (int i=1;i<visit.length; ++i){
            if (!visit[i]) sb.append(i);
        }
        return sb.toString();
    }
}
