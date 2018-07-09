package com.company;
// Bit
/**
 * 191. Number of 1 Bits

 Write a function that takes an unsigned integer and returns the number of '1' bits
 it has (also known as the Hamming weight).

 Example 1:

 Input: 11
 Output: 3
 Explanation: Integer 11 has binary representation 00000000000000000000000000001011
 Example 2:

 Input: 128
 Output: 1
 Explanation: Integer 128 has binary representation 00000000000000000000000010000000

 */
public class Numberof1Bits {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
