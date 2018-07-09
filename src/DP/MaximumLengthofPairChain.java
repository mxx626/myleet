package DP;
// DP, Greedy
import java.util.Comparator;
import java.util.Arrays;

public class MaximumLengthofPairChain {
    /**
     * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

     Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

     Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

     Example 1:
     Input: [[1,2], [2,3], [3,4]]
     Output: 2
     Explanation: The longest chain is [1,2] -> [3,4]
     Note:
     The number of given pairs will be in the range [1, 1000].

     * @param pairs
     * @return
     */
    // DP
    public int findLongestChain(int[][] pairs) {
        int row = pairs.length;
        int[] dp = new int[row+1];
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare (int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });
        dp[0]=0;
        dp[1]=1;
        for (int i=1; i<row; ++i){
            dp[i+1]=1;
            for (int j=0; j<i; ++j){
                if (pairs[i][0]>pairs[j][1]){
                    dp[i+1] = Math.max(dp[i+1], dp[j+1]+1);
                }
            }
        }
        return dp[row];
    }
    // Greedy
    public int findLongestChain1(int[][] pairs) {
        int row = pairs.length;
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare (int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });
        int end = pairs[0][1];
        int count = 1;
        for (int i=1; i<row; ++i){
            if (pairs[i][0]>end){
                count++;
                end = pairs[i][1];
            }
        }
        return count;
    }
}
