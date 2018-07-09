package com.company;
// Backtracking
/**
 * 282. Expression Add Operators

 Given a string that contains only digits 0-9 and a target value, return all possibilities
 to add binary operators (not unary) +, -, or * between the digits so they evaluate to the
 target value.

 Example 1:

 Input: num = "123", target = 6
 Output: ["1+2+3", "1*2*3"]
 Example 2:

 Input: num = "232", target = 8
 Output: ["2*3+2", "2+3*2"]
 Example 3:

 Input: num = "105", target = 5
 Output: ["1*0+5","10-5"]
 Example 4:

 Input: num = "00", target = 0
 Output: ["0+0", "0-0", "0*0"]
 Example 5:

 Input: num = "3456237490", target = 9191
 Output: []

 */

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        if (num==null || num.length()==0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        helper(num, new StringBuilder(), 0, target, 0, res, 0);
        return res;
    }
    private void helper(String arr, StringBuilder sb, long sum, int target, int s, List<String> res, long multied){
        if (s==arr.length() && target==sum){
            res.add(sb.toString());
            return;
        }
        int size = sb.length();
        for (int i=s; i<arr.length(); ++i){
            if (arr.charAt(s)=='0' && i!=s) break;
            long cur = Long.parseLong(arr.substring(s, i+1));
            if (s==0){
                helper(arr, sb.append(cur), cur, target, i+1, res, cur);
                sb.setLength(size);
            }
            else {
                helper(arr, sb.append("+").append(cur), sum+cur, target, i+1, res, cur);
                sb.setLength(size);

                helper(arr, sb.append("-").append(cur), sum-cur, target, i+1, res, -cur);
                sb.setLength(size);

                helper(arr, sb.append("*").append(cur), sum-multied+multied*cur, target, i+1, res, multied*cur);
                sb.setLength(size);
            }
        }
    }
}
