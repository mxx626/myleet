package com.company;
// String
/**
 * 541. Reverse String II
 DescriptionHintsSubmissionsDiscussSolution
 Given a string and an integer k, you need to reverse the first k characters for every
 2k characters counting from the start of the string. If there are less than k characters
 left, reverse all of them. If there are less than 2k but greater than or equal to k
 characters, then reverse the first k characters and left the other as original.
 Example:
 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"
 Restrictions:
 The string consists of lower English letters only.
 Length of the given string and k will in the range [1, 10000]

 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i=0; i<s.length(); i+=2*k){
            if (i+k>=s.length()) {
                swap(ch, i, s.length()-1);
            }
            else {
                swap(ch, i, i+k-1);
            }
        }
        return new String(ch);
    }
    private void swap (char[] ch, int i, int j){
        while (i<j){
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
            i++;
            j--;
        }
    }
}
