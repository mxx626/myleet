package DP;
// DP
public class MinimumASCIIDeleteSumforTwoStrings {
    /**
     * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

     Example 1:
     Input: s1 = "sea", s2 = "eat"
     Output: 231
     Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
     Deleting "t" from "eat" adds 116 to the sum.
     At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
     Example 2:
     Input: s1 = "delete", s2 = "leet"
     Output: 403
     Explanation: Deleting "dee" from "delete" to turn the string into "let",
     adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
     At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
     If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
     Note:

     0 < s1.length, s2.length <= 1000.
     All elements of each string will have an ASCII value in [97, 122].
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len1 = c1.length, len2 = c2.length;
        int[][] dp = new int[len1+1][len2+1];
        for (int i=0; i<len1; ++i){
            dp[i+1][0]=dp[i][0]+s1.charAt(i);
        }
        for (int i=0; i<len2; ++i){
            dp[0][i+1] = dp[0][i]+s2.charAt(i);
        }

        for (int i=0; i<len1; ++i){
            for (int j=0; j<len2; ++j){
                if (s1.charAt(i)==s2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j];
                }
                else {
                    dp[i+1][j+1]=Math.min(dp[i][j+1]+s1.charAt(i), dp[i+1][j]+s2.charAt(j));
                }
            }
        }
        return dp[len1][len2];
    }


    public int minimumDeleteSum2(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len1 = c1.length, len2 = c2.length;
        int[] dp = new int[len2+1];
        int pre = 0;
        for (int i=0; i<len2; ++i){
            dp[i+1] = dp[i]+s2.charAt(i);
        }
        for (int i=0; i<len1; ++i){
            dp[0] += c1[i];
            for (int j=0; j<len2; ++j){
                int tmp = dp[j+1];
                if (c1[i]==c2[j])
                    dp[j+1]=pre;
                else
                    dp[j+1]=Math.min(dp[j]+s2.charAt(j), tmp+s1.charAt(i));
                pre  = tmp;
            }
            pre = dp[0];
        }
        return dp[len2];
    }
}
