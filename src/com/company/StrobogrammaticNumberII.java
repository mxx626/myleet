package com.company;
// Recursion
import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {
    /**
     * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

     Find all strobogrammatic numbers that are of length = n.

     Example:

     Input:  n = 2
     Output: ["11","69","88","96"]

     * @param n
     * @return
     */
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        String str = "016986910";
        char[] ch = new char[n];
        helper(str, n, res, ch, 0, n-1);
        return res;
    }
    private void helper(String str, int n, List<String> res, char[] ch, int start, int end){
        if (start>end){
            res.add(new String(ch));
        }
        for (int i=0; i<5; ++i){
            if (i==0 && end-start==n-1 && n!=1) continue;
            if (start<end){
                ch[start]=str.charAt(i);
                ch[end]=str.charAt(8-i);
                helper(str, n, res, ch, start+1, end-1);
            }
            else if (start==end && (i==0 || i==1 ||  i==4)){
                ch[start]=str.charAt(i);
                helper(str, n, res, ch, start+1, end-1);
            }
        }
    }
}
