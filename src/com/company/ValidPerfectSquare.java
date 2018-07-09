package com.company;
// Binary Search
public class ValidPerfectSquare {
    /**
     * Given a positive integer num, write a function which returns True if num is a perfect square else False.

     Note: Do not use any built-in library function such as sqrt.

     Example 1:

     Input: 16
     Returns: True
     Example 2:

     Input: 14
     Returns: False
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num==1) return true;
        long l = 0;
        long r = num/2;
        while (l<=r){
            long m = (r+l)/2;
            if (m*m==num) return true;
            else if (m*m<num) l=m+1;
            else r=m-1;
        }
        return false;
    }
}
