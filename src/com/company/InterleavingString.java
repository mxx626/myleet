package com.company;
// DP
public class InterleavingString {
    /**
     * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

     Example 1:

     Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     Output: true
     Example 2:

     Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
     Output: false

     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()) return false;
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] ch3 = s3.toCharArray();
        boolean[][] dp = new boolean[ch1.length+1][ch2.length+1];
        dp[0][0]=true;
        for (int i=0; i<ch1.length; ++i){
            dp[i+1][0]= dp[i][0] && (ch1[i]==ch3[i]);
        }
        for (int j=0; j<ch2.length; ++j){
            dp[0][j+1]= dp[0][j] && (ch2[j]==ch3[j]);
        }
        for (int i=1; i<=s1.length(); ++i){
            for (int j=1; j<=s2.length(); ++j){
                dp[i][j] = (dp[i-1][j] && (ch1[i-1]==ch3[i+j-1]))||(dp[i][j-1]&&(ch2[j-1]==ch3[j+i-1]));
            }
        }
        return dp[ch1.length][ch2.length];
    }
}
