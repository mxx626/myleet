package com.company;

import java.util.ArrayList;
import java.util.List;

public class Backtracking_LetterCasePermutation {
    /**
     * Given a string S, we can transform every letter individually to be lowercase or uppercase
     * to create another string.  Return a list of all possible strings we could create.
     Examples:
     Input: S = "a1b2"
     Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

     Input: S = "3z4"
     Output: ["3z4", "3Z4"]

     Input: S = "12345"
     Output: ["12345"]

     Note:

     S will be a string with length at most 12.
     S will consist only of letters or digits.

     * **/
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        DFS(S.toCharArray(), 0, ans);
        return ans;
    }
    private void DFS(char[] S, int pos, List<String> ans){
        if (pos==S.length){
            ans.add(new String(S));
            return;
        }
        DFS(S, pos+1, ans);
        if (!Character.isLetter(S[pos])) return;
        S[pos]^=1<<5;
        DFS(S, pos+1, ans);
        S[pos]^=1<<5;
    }
}
