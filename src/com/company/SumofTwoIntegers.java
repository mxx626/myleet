package com.company;
// Bit
/**
 * 371. Sum of Two Integers

 Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.
 */
public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        if (b==0) return a;
        int carry = (a&b)<<1;
        int sum = a^b;
        return getSum(sum, carry);
    }
}
