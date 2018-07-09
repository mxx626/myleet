package String;
// TAG: DP, Extend Range, Manacher
public class LongestPalindromicSubstring {
    /**
     *Given a string s, find the longest palindromic substring in s.
     * You may assume that the maximum length of s is 1000.

     Example:

     Input: "babad"

     Output: "bab"

     Note: "aba" is also a valid answer.


     Example:

     Input: "cbbd"

     Output: "bb"
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {            //DP
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start=0, maxLen=0;
        for (int j=0; j<len; ++j){
            for (int i=0; i<=j; ++i){
                dp[i][j] = (s.charAt(i)==s.charAt(j)&&(j-i<=2 || dp[i+1][j-1]));
                if (dp[i][j]){
                    if (j-i+1>maxLen){
                        maxLen=j-i+1;
                        start=i;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }


    private String res="";
    private int maxLen=0;
    public String longestPalindrome(String s) {        //extend range
        for (int i=0; i<s.length(); ++i){
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return res;
    }
    private void helper(String s, int left, int right){
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        if (right-left-1>maxLen){
            maxLen=right-left-1;
            res=s.substring(left+1, right);
        }
    }
/////////////////////////////////////////////!!!!!!!!!!!!!!

    int len = 0, maxLength = 0, init = 0;
    public String longestPalindrome3(String s) {             //manacher
        char[] chars = s.toCharArray();
        len = s.length();
        if (len <= 1) return s;
        for (int i = 0; i < len; i++) {
            i = manacher(chars, i);
        }
        return s.substring(init, init + maxLength);
    }
    public int manacher(char[] chars, int k) {
        int i = k - 1, j = k;
        while (j < len - 1 && chars[j] == chars[j + 1]) j++;
        int nextCenter = j++;
        while (i >= 0 && j < len && chars[i] == chars[j]) {
            i--;
            j++;
        }
        if (j - i - 1 > maxLength) {
            maxLength = j - i - 1;
            init = i + 1;
        }
        return nextCenter;
    }
}
