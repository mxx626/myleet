package com.company;
// Backtracking
import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    /**
     * Write a function to generate the generalized abbreviations of a word.

     Note: The order of the output does not matter.

     Example:

     Input: "word"
     Output:
     ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

     * @param word
     * @return
     */
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        char[] arr = word.toCharArray();
        helper(arr, 0, "", 0, res);
        return res;
    }
    private void helper(char[] arr, int s, String str, int count, List<String> res){
        if (s==arr.length){
            if (count>0){
                res.add(str+count);
            }
            else {
                res.add(str);
            }
            return;
        }
        helper(arr, s+1, str, count+1, res);
        helper(arr, s+1, str+(count==0 ? "" : count)+arr[s], 0, res);
    }
}
