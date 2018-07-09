package com.company;
// DP, Heap
public class UglyNumberII {
    /**
     * Write a program to find the n-th ugly number.

     Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
     For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

     Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int[] dp = new int[n];
        dp[0]=1;
        int m2=0, m3=0, m5=0;
        int multi2=2, multi3=3, multi5=5;
        for (int i=1; i<n; ++i){
            int tmp = Math.min(multi2, Math.min(multi3, multi5));
            dp[i]=tmp;
            if (tmp == multi2){
                m2++;
                multi2 = dp[m2]*2;
            }
            if (tmp == multi3){
                m3++;
                multi3 = dp[m3]*3;
            }
            if (tmp == multi5){
                m5++;
                multi5 = dp[m5]*5;
            }
        }
        return dp[n-1];
    }
}
