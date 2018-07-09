package Math;
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
}
