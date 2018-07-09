package com.company;
// String
public class LongestCommonPrefix {
    /**
     * Write a function to find the longest common prefix string amongst an array of strings.

     If there is no common prefix, return an empty string "".

     Example 1:

     Input: ["flower","flow","flight"]
     Output: "fl"
     Example 2:

     Input: ["dog","racecar","car"]
     Output: ""
     Explanation: There is no common prefix among the input strings.
     Note:

     All given inputs are in lowercase letters a-z.
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0) return "";
        if (strs.length==1) return strs[0];
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<strs[0].length(); ++i){
            if (isValid(strs, i)){
                sb.append(strs[0].charAt(i));
            }
            else break;
        }
        return sb.toString();
    }
    private boolean isValid(String[] strs, int idx){
        char c = strs[0].charAt(idx);
        for (int i=1; i<strs.length; ++i){
            if (strs[i].length()<=idx || c!=strs[i].charAt(idx)){
                return false;
            }
        }
        return true;
    }
}
