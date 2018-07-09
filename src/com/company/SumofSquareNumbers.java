package com.company;
// Math
public class SumofSquareNumbers {
    /**
     * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

     Example 1:
     Input: 5
     Output: True
     Explanation: 1 * 1 + 2 * 2 = 5
     Example 2:
     Input: 3
     Output: False
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        for (long i=0; i*i<=c; ++i){
            if (isSquare(c-i*i))
                return true;
        }
        return false;
    }
    private boolean isSquare(long x){
        if (x==0 || x==1) return true;
        long l = 0;
        long r = x/2;
        while (l<=r){
            long m = l+(r-l)/2;
            if (m*m==x) return true;
            else if (m*m<x) l=m+1;
            else r=m-1;
        }
        return l*l==x;
    }
}
