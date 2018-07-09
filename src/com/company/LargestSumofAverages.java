package com.company;
// DP, Memo
public class LargestSumofAverages {
    /**
     * We partition a row of numbers A into at most K adjacent (non-empty) groups,
     * then our score is the sum of the average of each group. What is the largest
     * score we can achieve?

     Note that our partition must use every number in A, and that scores are not
     necessarily integers.

     Example:
     Input:
     A = [9,1,2,3,9]
     K = 3
     Output: 20
     Explanation:
     The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 +
     (1 + 2 + 3) / 3 + 9 = 20.
     We could have also partitioned A into [9, 1], [2], [3, 9], for example.
     That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.


     Note:

     1 <= A.length <= 100.
     1 <= A[i] <= 10000.
     1 <= K <= A.length.
     Answers within 10^-6 of the correct answer will be accepted as correct.
     * @param A
     * @param K
     * @return
     */
    //DP
    public double largestSumOfAverages(int[] A, int K) {
        int len = A.length;
        double[][] dp = new double[K+1][len+1];
        double[] sum = new double[len+1];
        for (int i=1; i<=len; ++i){
            sum[i]=sum[i-1]+A[i-1];
            dp[1][i]=sum[i]/i;
        }
        for (int k=2; k<=K; ++k){
            for (int m=k; m<=len; ++m){
                for (int n=k-1; n<m; ++n){
                    dp[k][m]=Math.max(dp[k][m], dp[k-1][n]+(sum[m]-sum[n])/(m-n));
                }
            }
        }
        return dp[K][len];
    }


    // Recursion and memorization
    private double[][] memo=null;
    private double[]  sum=null;
    public double largestSumOfAverages1(int[] A, int K) {
        int len = A.length;
        memo  = new double[K+1][len+1];
        sum = new double[len+1];
        for (int i=1; i<=len; ++i){
            sum[i]=sum[i-1]+A[i-1];
            memo[1][i]=sum[i]/i;
        }
        return LSA(K, len);
    }
    private double LSA(int k, int m){
        if (memo[k][m]>0) return memo[k][m];
        for (int i=k-1; i<m; ++i){
            memo[k][m] = Math.max(memo[k][m], LSA(k-1, i)+(sum[m]-sum[i])/(m-i));
        }
        return memo[k][m];
    }
}
