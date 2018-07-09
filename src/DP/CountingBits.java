package DP;
// DP
public class CountingBits {
    /**
     * Given a non negative integer number num. For every numbers i in the
     * range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

     Example:
     For num = 5 you should return [0,1,1,2,1,2].
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for (int i=1; i<=num; ++i)
        {
            if (i%2==1) dp[i] = dp[i/2]+1;
            if (i%2==0) dp[i] = dp[i/2];
        }
        return dp;
    }
}
