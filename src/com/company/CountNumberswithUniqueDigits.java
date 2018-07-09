package com.company;
// DP, Backtracking
public class CountNumberswithUniqueDigits {
    /**
     * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

     Example:
     Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

     Credits:
     Special thanks to @memoryless for adding this problem and creating all test cases.


     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int res=9;
        int x=10;
        int prev = 9;
        for (int i=2; i<=n; ++i){
            int tmp = prev;
            prev = prev*(--x);
            res+=prev;
        }
        return res+1;
    }
}
