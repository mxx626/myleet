package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * **/
public class Backtracking_GenerateParentheses {
    private List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n==0) return res;
        helper("", n, 0, 0);
        return res;
    }
    public void helper (String sb, int n, int left, int right){
        if (sb.length()==n*2){
            res.add(sb);
            return;
        }
        if (left<n){
            helper((sb+"("), n, left+1, right);
        }
        if (right<left){
            helper((sb+")"), n, left, right+1);
        }
    }
}
