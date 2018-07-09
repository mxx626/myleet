package com.company;
// TAG: String, DP
public class DeleteOperationforTwoStrings {
    /**
     *Given two words word1 and word2, find the minimum number of steps required to make
     * word1 and word2 the same, where in each step you can delete one character in either
     * string.

     Example 1:
     Input: "sea", "eat"
     Output: 2
     Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
     Note:
     The length of given words won't exceed 500.
     Characters in given words can only be lower-case letters.

     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i=0; i<word1.length(); ++i){
            for (int j=0; j<word2.length(); ++j){
                if (word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }
                else dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return word1.length()+word2.length()-2*dp[word1.length()][word2.length()];
    }
    /////////////////
    public int minDistance2(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i=0; i<=word1.length(); ++i){
            dp[i][0]=i;
        }
        for (int i=0; i<=word2.length(); ++i){
            dp[0][i]=i;
        }

        for (int i=0; i<word1.length(); ++i){
            for (int j=0; j<word2.length(); ++j){
                if (word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }
                else dp[i+1][j+1] = Math.min(dp[i+1][j], dp[i][j+1])+1;
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public int minDistance3 (String word1, String word2){
        int[] dp = new int[word2.length()+1];
        for (int i=0; i<=word1.length(); ++i){
            int[] tmp = new int[word2.length()+1];
            for (int j=0; j<=word2.length(); ++j){
                if (i==0 || j==0){
                    tmp[j]=i+j;
                }
                else if (word1.charAt(i-1)==word2.charAt(j-1)){
                    tmp[j]=dp[j-1];
                }
                else {
                    tmp[j]=1+Math.min(dp[j], tmp[j-1]);
                }
            }
            dp=tmp;
        }
        return dp[word2.length()];
    }
}
