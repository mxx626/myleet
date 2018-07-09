package com.company;
// TAG: Binary Search
public class DivideTwoIntegers {
    /**
     * Given two integers dividend and divisor, divide two integers without using multiplication,
     * division and mod operator.

     Return the quotient after dividing dividend by divisor.

     Example 1:

     Input: dividend = 10, divisor = 3
     Output: 3
     Example 2:

     Input: dividend = 7, divisor = -3
     Output: -2
     Note:

     Both dividend and divisor will be 32-bit signed integers.
     The divisor will never be 0.
     Assume we are dealing with an environment which could only store integers within the 32-bit
     signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your
     function returns 231 − 1 when the division result overflows.
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int sign=1;
        if ((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) sign=-1;
        long ldend = Math.abs((long)dividend);
        long ldsor = Math.abs((long)divisor);
        //     System.out.println(ldend);
        if (ldend==0 || (ldend<ldsor)) return 0;
        long lres = div(ldend, ldsor);
        if (lres > Integer.MAX_VALUE){
            return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)(sign*lres);
    }
    private long div(long ldend, long ldsor){
        if (ldend<ldsor) return 0;
        long sum = ldsor;
        long mul = 1;
        while ((sum+sum)<=ldend){
            sum += sum;
            mul += mul;
        }
        return mul + div(ldend-sum, ldsor);
    }
}
