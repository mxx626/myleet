package DP;
// DP
public class LongestPalindromicSubsequence {
    /**
     * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

     Example 1:
     Input:

     "bbbab"
     Output:
     4
     One possible longest palindromic subsequence is "bbbb".
     Example 2:
     Input:

     "cbbd"
     Output:
     2
     One possible longest palindromic subsequence is "bb".
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        char[] ch = s.toCharArray();
        int[][] dp = new int[ch.length][ch.length];
        for (int i=0; i<ch.length; ++i) dp[i][i]=1;
        for (int i=1; i<ch.length; ++i){
            for (int j=i-1; j>=0; --j){
                if (ch[i]==ch[j]){
                    dp[j][i]= i-j==1 ? 2 : dp[j+1][i-1]+2;
                }
                else {
                    dp[j][i]=Math.max(dp[j+1][i], dp[j][i-1]);
                }
            }
        }
        return dp[0][ch.length-1];
    }

    public int longestPalindromeSubseq2(String s) {
        char[] ch = s.toCharArray();
        int[] dp = new int[ch.length];
        for (int i=0; i<ch.length; ++i){
            dp[i]=1;
            int prev = 0;
            for (int j=i-1; j>=0; --j){
                int tmp = dp[j];
                if (ch[i]==ch[j]) dp[j]=prev+2;
                else dp[j]=Math.max(dp[j], dp[j+1]);
                prev=tmp;
            }
        }
        return dp[0];
    }
}
