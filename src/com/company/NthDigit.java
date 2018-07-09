package com.company;
// Math
/**
 * 400. Nth Digit

 Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

 Note:
 n is positive and will fit within the range of a 32-bit signed integer (n < 231).

 Example 1:

 Input:
 3

 Output:
 3
 Example 2:

 Input:
 11

 Output:
 0

 Explanation:
 The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

 */
public class NthDigit {
    public int findNthDigit(int n) {
        int digits = 1;
        int start = 1;
        long num = 9;
        while (n>digits*num){
            n -= digits*num;
            digits++;
            num *= 10;
            start *= 10;
        }
        int res = Integer.toString(start+((n-1)/digits)).charAt((n-1)%digits)-'0';
        return res;
    }
    /**
     * The reason why (n-1) is to keep the correct digits finally in number
     * they correspond to. Eg: if we are trying to find the 192th digit, we
     * know range from 1th digit to 9th digit belongs to numbers from 1 to 9
     * and range from 10th to 189th belongs to numbers from 10 to 99, right?
     * So it is obvious that the next number should be 100 and the 192th digit
     * should be the 3rd digit of 100(now n=3). OK, back to the code, if we
     * do not minus 1 from n and then devide the len, the 192th digit would go
     * to the next number which is 101.
     * **/
}
