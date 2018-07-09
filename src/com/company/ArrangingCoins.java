package com.company;
// Binary Search
public class ArrangingCoins {
    /**
     * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

     Given n, find the total number of full staircase rows that can be formed.

     n is a non-negative integer and fits within the range of a 32-bit signed integer.

     Example 1:

     n = 5

     The coins can form the following rows:
     ¤
     ¤ ¤
     ¤ ¤

     Because the 3rd row is incomplete, we return 2.
     Example 2:

     n = 8

     The coins can form the following rows:
     ¤
     ¤ ¤
     ¤ ¤ ¤
     ¤ ¤

     Because the 4th row is incomplete, we return 3.

     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        if (n==0) return 0;
        long s=1, e=n;
        while (s+1<e){
            long m = s+(e-s)/2;
            if (m*(m+1)/2==n) return (int)m;
            if (m*(m+1)/2<n) s=m;
            else e=m;
        }
        return (1+e)*e/2<n ? (int)e : (int)s;
    }
}
