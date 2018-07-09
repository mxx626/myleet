package com.company;
// String
/**
 * 680. Valid Palindrome II

 Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

 Example 1:
 Input: "aba"
 Output: True
 Example 2:
 Input: "abca"
 Output: True
 Explanation: You could delete the character 'c'.
 Note:
 The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int i=0, j=s.length()-1;
        return helper(s, i, j, 0);
    }
    private boolean helper(String s, int start, int end, int skip){
        if (start>=end) return true;
        if (s.charAt(start)==s.charAt(end)){
            return helper(s, start+1, end-1, skip);
        }
        else {
            if (skip==1) return false;
            else {
                skip++;
                return helper(s, start+1, end, skip)||helper(s, start, end-1, skip);
            }
        }
    }
}
