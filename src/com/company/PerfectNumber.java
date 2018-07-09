package com.company;
// Math
public class PerfectNumber {
    /**
     * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

     Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
     Example:
     Input: 28
     Output: True
     Explanation: 28 = 1 + 2 + 4 + 7 + 14
     Note: The input number n will not exceed 100,000,000. (1e8)
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if (num==0 || num==1) return false;
        int sum=0;
        for (int i=2; i*i<=num; ++i){
            if (num%i==0){
                sum += i+(num/i);
            }
        }
        sum++;
        return sum==num;

    }
}
