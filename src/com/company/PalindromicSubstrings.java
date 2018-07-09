package com.company;
// TAG: String, Extend Range, DP
public class PalindromicSubstrings {
    /**
     * Given a string, your task is to count how many palindromic substrings in this string.

     The substrings with different start indexes or end indexes are counted as different
     substrings even they consist of same characters.

     Example 1:
     Input: "abc"
     Output: 3
     Explanation: Three palindromic strings: "a", "b", "c".
     Example 2:
     Input: "aaa"
     Output: 6
     Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
     Note:
     The input string length won't exceed 1000.

     * @param s
     * @return
     */
    public int countSubstrings3(String s) {
        if (s==null ||s.length()==0) return 0;
        int count=0;
        int len=s.length();
        for (int center=0; center<len; ++center){
            count += helper(s, center, center);
            count += helper(s, center, center+1);
        }
        return count;
    }
    private int helper(String s, int left, int right){
        int count1=0;
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            count1++;
            left--;
            right++;
        }
        return count1;
    }


    
    public int countSubstrings(String s) {
        if (s==null ||s.length()==0) return 0;
        char[] ch = s.trim().toCharArray();
        int len = ch.length;
        boolean[][] dp = new boolean [len][len];
        int count=0;
        for (int i=0; i<len; ++i){
            for (int j=0; j<=i; ++j){
                dp[j][i] = ch[i]==ch[j] && (i-j<=2 || dp[j+1][i-1]);
                if (dp[j][i]) count++;
            }
        }
        return count;
    }

    public int countSubstrings2(String s) {
        if (s==null ||s.length()==0) return 0;
        int len=s.length(), count=0;
        for (int center=0; center<=2*len-1; ++center){
            int left = center/2;
            int right = left + center%2;
            while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}
