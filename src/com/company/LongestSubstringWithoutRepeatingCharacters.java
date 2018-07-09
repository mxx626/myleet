package com.company;
// TAG: HashTable, Two Pointer, String
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Given a string, find the length of the longest substring without repeating characters.

     Examples:

     Given "abcabcbb", the answer is "abc", which the length is 3.

     Given "bbbbb", the answer is "b", with the length of 1.

     Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be
     a substring, "pwke" is a subsequence and not a substring.


     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0) return 0;
        char[] ch = s.toCharArray();
        int[] set = new int[128];
        int p1=0, p2=0, res=0;
        for (p2=0; p2<ch.length;p2++){
            if (set[ch[p2]]==0) {
                set[ch[p2]]++;
            }
            else {
                while (ch[p1]!=ch[p2]){
                    set[ch[p1]]--;
                    p1++;
                }
                p1++;
            }
            res=Math.max(res, p2-p1+1);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] set = new int[128];
        int len = s.length();
        int p1=0, p2=0, res=0;
        for (p2=0; p2<len;p2++){
            p1 = Math.max(set[s.charAt(p2)], p1);
            res = Math.max(res, p2-p1+1);
            set[s.charAt(p2)]=p2+1;
        }
        return res;
    }
}
