package com.company;

import java.util.Stack;

/**Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
 (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

 Example 1:
 Input: N = 10
 Output: 9

 Example 2:
 Input: N = 1234
 Output: 1234

 Example 3:
 Input: N = 332
 Output: 299

        3   3       2
 cur    1   2       3       4       5
 top    2   3       4       5       4
 res    1   12    123    1234   12344

 Note: N is an integer in the range [0, 10^9].
 **/
public class Greedy_MonotoneIncreaseDigits {
    public int monotoneIncreasingDigits(int N) {
        if (N<10) return N;
        char[] arr = String.valueOf(N).toCharArray();
        int i=1;
        while (i<arr.length && arr[i-1]<=arr[i]) {
            i++;
        }
        while (i>0 && i<arr.length && arr[i-1]>arr[i]){
            arr[--i]--;
        }
        for (int j=i; j<arr.length; j++){
            arr[j]='9';
        }
        return  Integer.parseInt(new String(arr));
    }
}
