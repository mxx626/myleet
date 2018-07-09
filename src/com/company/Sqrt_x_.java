package com.company;
// Binary Search
public class Sqrt_x_ {
    /**
     * mplement int sqrt(int x).

     Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

     Since the return type is an integer, the decimal digits are truncated and only the integer
     part of the result is returned.

     Example 1:

     Input: 4
     Output: 2
     Example 2:

     Input: 8
     Output: 2
     Explanation: The square root of 8 is 2.82842..., and since
     the decimal part is truncated, 2 is returned.
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x==0 || x==1) return x;
        int l = 0;
        int r = x/2;
        while (l+1<r){
            int m = l+(r-l)/2;
            if (m<x/m) l=m;
            else r=m;
        }
        return r>x/r ? l : r;
    }
}
