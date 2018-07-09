package com.company;
// String
public class FirstUniqueCharacterinaString {
    /**
     * 387. First Unique Character in a String

     Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

     Examples:

     s = "leetcode"
     return 0.

     s = "loveleetcode",
     return 2.
     Note: You may assume the string contain only lowercase letters.
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int res = -1;
        for (char i='a'; i<='z'; ++i){
            int idx = s.indexOf(i);
            if (idx!=-1 && s.lastIndexOf(i)==idx){
                if (res==-1) res=idx;
                else res=Math.min(res, idx);
            }
        }
        return res;
    }
}
