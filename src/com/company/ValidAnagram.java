package com.company;
// HashTable, count sort
public class ValidAnagram {
    /**
     * Given two strings s and t , write a function to determine if t is an anagram of s.

     Example 1:

     Input: s = "anagram", t = "nagaram"
     Output: true
     Example 2:

     Input: s = "rat", t = "car"
     Output: false
     Note:
     You may assume the string contains only lowercase alphabets.

     Follow up:
     What if the inputs contain unicode characters? How would you adapt your solution to such case?
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        for (int i=0; i<s.length(); ++i){
            map1[s.charAt(i)]++;
            map2[t.charAt(i)]++;
        }

        for (int i=0; i<256; ++i){
            if (map1[i]!=map2[i]) return false;
        }
        return true;
    }
}
