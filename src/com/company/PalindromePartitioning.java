package com.company;

import java.util.ArrayList;
import java.util.List;
// Backtracking

/**
 * 131. Palindrome Partitioning

 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 Example:

 Input: "aab"
 Output:
 [
 ["aa","b"],
 ["a","a","b"]
 ]

 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        if (len==0) return res;
        helper(res, new ArrayList<>(), s, 0, len);
        return res;
    }
    private void helper(List<List<String>> res, List<String> list, String s, int l, int r){
        if (l==r){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=l+1; i<=r; ++i){
            if (isValid(s, l, i)){
                list.add(s.substring(l, i));
                helper(res, list, s, i, r);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isValid(String s, int i, int j){
        if (i==j-1) return true;
        while (i<j-1){
            if (s.charAt(i) != s.charAt(j-1)) return false;
            i++;
            j--;
        }
        return true;
    }
}
