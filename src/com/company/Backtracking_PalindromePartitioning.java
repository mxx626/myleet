package com.company;

import java.util.ArrayList;
import java.util.List;

public class Backtracking_PalindromePartitioning {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * Return all possible palindrome partitioning of s.
     *
     * For example, given s = "aab",
     * Return
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * ]
     * */
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s==null || s.length()==0) return res;
        helper(s, new ArrayList<>(), 0);
        return res;
    }
    private void helper (String s, List<String> list, int start){
        if (start==s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=start; i<s.length(); ++i){
            if (isValid(s, start, i)){
                list.add(s.substring(start, i+1));
                helper(s, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isValid (String s, int left , int right){
        while (left<right){
            if (s.charAt(left++)!=s.charAt(right--))
                return false;
        }
        return true;
    }
}
