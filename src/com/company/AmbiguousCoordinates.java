package com.company;
// String
import java.util.ArrayList;
import java.util.List;

/**
 * 816. Ambiguous Coordinates

 We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  Then, we removed all commas,
 decimal points, and spaces, and ended up with the string S.  Return a list of strings representing
 all possibilities for what our original coordinates could have been.

 Our original representation never had extraneous zeroes, so we never started with numbers like
 "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with less
 digits.  Also, a decimal point within a number never occurs without at least one digit occuring
 before it, so we never started with numbers like ".1".

 The final answer list can be returned in any order.  Also note that all coordinates in the final
 answer have exactly one space between them (occurring after the comma.)

 Example 1:
 Input: "(123)"
 Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 Example 2:
 Input: "(00011)"
 Output:  ["(0.001, 1)", "(0, 0.011)"]
 Explanation:
 0.0, 00, 0001 or 00.01 are not allowed.
 Example 3:
 Input: "(0123)"
 Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 Example 4:
 Input: "(100)"
 Output: [(10, 0)]
 Explanation:
 1.0 is not allowed.


 Note:

 4 <= S.length <= 12.
 S[0] = "(", S[S.length - 1] = ")", and the other elements in S are digits.

 */
public class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList<>();
        for (int i=2; i<S.length()-1; ++i){
            String first = S.substring(1,i);
            String second = S.substring(i, S.length()-1);
            List<String> list1 = helper(first);
            List<String> list2 = helper(second);
            for (String str1 : list1){
                for (String str2 : list2){
                    res.add("("+str1+", "+str2+")");
                }
            }
        }
        return res;
    }
    private List<String> helper(String str){
        int len = str.length();
        List<String> res = new ArrayList<>();
        if (len==0 || len>1 && str.charAt(0)=='0' && str.charAt(len-1)=='0') return res;
        if (len>1 && str.charAt(0)=='0'){
            res.add(str.charAt(0)+"."+str.substring(1));
            return res;
        }
        res.add(str);
        if (str.charAt(len-1)=='0') return res;
        for (int i=1; i<str.length(); ++i){
            res.add(str.substring(0,i)+"."+str.substring(i));
        }
        return res;
    }
}
