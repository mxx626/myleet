package com.company;
// HashTable
public class LongestPalindrome {
    /**
     * Given a string which consists of lowercase or uppercase letters, find the
     * length of the longest palindromes that can be built with those letters.

     This is case sensitive, for example "Aa" is not considered a palindrome here.

     Note:
     Assume the length of given string will not exceed 1,010.

     Example:

     Input:
     "abccccdd"

     Output:
     7

     Explanation:
     One longest palindrome that can be built is "dccaccd", whose length is 7.
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int[] count = new int[64];
        for (char c : s.toCharArray()){
            count[c-'A']++;
        }

        int res = 0;
        for (int i : count){
            if (i%2==1) res += (i-1);
            else res += i;
        }

        return res==s.length() ? res : res+1;
    }
}
