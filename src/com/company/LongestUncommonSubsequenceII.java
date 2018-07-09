package com.company;
// TAG: String
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestUncommonSubsequenceII {
    /**
     * Given a list of strings, you need to find the longest uncommon subsequence among them.
     * The longest uncommon subsequence is defined as the longest subsequence of one of these
     * strings and this subsequence should not be any subsequence of the other strings.

     A subsequence is a sequence that can be derived from one sequence by deleting some
     characters without changing the order of the remaining elements. Trivially, any string
     is a subsequence of itself and an empty string is a subsequence of any string.

     The input will be a list of strings, and the output needs to be the length of the longest
     uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

     Example 1:

     Input: "aba", "cdc", "eae"
     Output: 3

     Note:

     All the given strings' lengths will not exceed 10.
     The length of the given list will be in the range of [2, 50].
     首先分析一下最长非公共子串的特征，假设有若干个字符串，其中最长非公共子串为 Sm，它的长度为 Sm.length()。从子串的定义上，
     我们可以知道这个 Sm 有两种可能的构成：

     Sm 为某一个字符串本身。
     Sm 为某一个小于父串长度的子串。

     我们可以证明 Sm 只能为第一种情况。
     首先我们假设 2 是成立的，其中 Sm 的父串是 Sf，那么说明 Sf 是某一个更长字符串的字串，所以导致 Sf 本身不能最为最长非公共子串。
     而由于 Sf 是某一个字符串的字串，那么 Sm 理应也是这一个字符串的子串，因为他们是包含关系，所以 Sm 是最长非公共子串跟假设 2 是矛盾的。

     既然最长非公共子串只能是某个字符串本身，搜索的时候只需针对整个字符串就行。比较容易的方法是，
     搜索出所有可以成为非公共子串的字符串，然后在从中选出最长的，就是所需要的字符串。
     * **/
    public int findLUSlength(String[] strs) {
        if (strs==null || strs.length==0) return 0;
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()!=o2.length()){
                    return o2.length()-o1.length();
                }
                else return o1.compareTo(o2);
            }
        });
        for (int i=0; i<strs.length; ++i){
            String first = strs[i];
            boolean flag=true;
            for(int j=0; j<strs.length; ++j){
                if (i==j) continue;
                String second = strs[j];
                if (first.equals(second) || isSubsequence(first, second)){
                    flag=false;
                    break;
                }
            }
            if (flag==true) return first.length();
        }
        return -1;
    }
    private boolean isSubsequence (String sub, String string){
        int subIdx=0, strIdx=0;
        while (subIdx<sub.length()&& strIdx<string.length()){
            if (sub.charAt(subIdx)==string.charAt(strIdx)){
                subIdx++;
            }
            strIdx++;
            if (subIdx==sub.length()) return true;
        }
        return false;
    }

    public int findLUSlength2(String[] strs) {
        int max=-1;
        for (int i=0; i<strs.length; ++i){
            int j;
            for ( j=0; j<strs.length; ++j){
                if (i!=j && isSubsequence(strs[i], strs[j])){
                    break;
                }
            }
            if (j==strs.length) max=Math.max(max, strs[i].length());
        }
        return max;
    }
}
