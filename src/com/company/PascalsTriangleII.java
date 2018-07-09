package com.company;
// Array, DP

import java.util.Arrays;
import java.util.List;

/**
 * 119. Pascal's Triangle II

 Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

 Note that the row index starts from 0.


 In Pascal's triangle, each number is the sum of the two numbers directly above it.

 Example:

 Input: 3
 Output: [1,3,3,1]
 Follow up:

 Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        Integer[] arr = new Integer[rowIndex+1];
        arr[0]=1;
        for (int i=1; i<=rowIndex; ++i){
            int left = 1;
            for (int j=0; j<=i; ++j){
                if (j==0) arr[j]=1;
                else if (j==i) arr[j]=1;
                else {
                    int tmp1 = arr[j];
                    arr[j]=left+tmp1;
                    left = tmp1;
                }
            }
        }
        return Arrays.asList(arr);
    }
}
