package com.company;
// Math, String
/**
 * 67. Add Binary

 Given two binary strings, return their sum (also a binary string).

 The input strings are both non-empty and contains only characters 1 or 0.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"

 */
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int i=ca.length-1, j=cb.length-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i>=0 || j>=0){
            int sum = carry;
            if (i>=0) sum += ca[i--]-'0';
            if (j>=0) sum += cb[j--]-'0';
            sb.insert(0, sum%2);
            carry = sum/2;
        }
        if (carry!=0) sb.insert(0, carry);
        return sb.toString();
    }
}
