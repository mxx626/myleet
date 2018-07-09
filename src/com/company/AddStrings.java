package com.company;
// Math
/**
 * 415. Add Strings

 Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

 Note:

 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int i=num1.length()-1, j=num2.length()-1;
        StringBuilder sb = new StringBuilder();
        while (i>=0 || j>=0){
            char n1 = ' ';
            char n2 = ' ';
            if (i>=0) {
                n1 = num1.charAt(i--);
            }
            if (j>=0){
                n2 = num2.charAt(j--);
            }
            int tmp = (n1==' ' ? 0 : (n1-'0')) + (n2==' ' ? 0 : (n2-'0')) + carry;
            sb.insert(0, tmp%10);
            carry = tmp/10;
        }
        if (carry!=0) sb.insert(0, carry);
        return sb.toString();
    }
}
