package com.company;
// TAG: Arrays
public class PlusOne {
    /**
     * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

     You may assume the integer do not contain any leading zero, except the number 0 itself.

     The digits are stored such that the most significant digit is at the head of the list.
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int carry=0, len=digits.length;
        for (int i=len-1; i>=0; --i){
            if (i==len-1){
                digits[i]++;
            }
            digits[i] = digits[i]+carry;
            carry = digits[i]/10;
            digits[i] = digits[i]%10;
            if (carry==0) return digits;
        }
        int[] res = new int[len+1];
        res[0]=1;

        return res;
    }
    //
    public int[] plusOne2(int[] digits) {
        for (int i=digits.length-1; i>=0; --i){
            if (digits[i]!=9) {
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] res = new int[digits.length+1];
        res[0]=1;

        return res;
    }
}
