package com.company;

public class DP_EditDistance {
    /**
     *  Given two words word1 and word2, find the minimum number of steps required to convert
     *  word1 to word2. (each operation is counted as 1 step.)
     *  You have the following 3 operations permitted on a word:
     *  a) Insert a character
     *  b) Delete a character
     *  c) Replace a character
     *
     *
         f(i, j - 1) represents insert operation
         f(i - 1, j) represents delete operation
         f(i - 1, j - 1) represents replace operation
     * **/
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i=0; i<=word1.length(); ++i){
            for (int j=0; j<=word2.length(); ++j){
                if (i==0 && j==0) continue;
                else if (i==0) {
                    dp[i][j]=j;
                }
                else if (j==0){
                    dp[i][j]=i;
                }
                else if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {//              replace                  delete       insert
                    dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
