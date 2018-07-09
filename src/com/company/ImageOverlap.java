package com.company;
// Array
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 835. Image Overlap

 Two images A and B are given, represented as binary, square matrices
 of the same size.  (A binary matrix has only 0s and 1s as values.)

 We translate one image however we choose (sliding it left, right, up,
 or down any number of units), and place it on top of the other image.
 After, the overlap of this translation is the number of positions that
 have a 1 in both images.

 (Note also that a translation does not include any kind of rotation.)

 What is the largest possible overlap?

 Example 1:

 Input: A = [[1,1,0],
 [0,1,0],
 [0,1,0]]
 B = [[0,0,0],
 [0,1,1],
 [0,0,1]]
 Output: 3
 Explanation: We slide A to right by 1 unit and down by 1 unit.
 Notes:

 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 0 <= A[i][j], B[i][j] <= 1
 */
public class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> list_a = new ArrayList<>();
        List<Integer> list_b = new ArrayList<>();
        for (int i=0; i<N*N; ++i){
            if (A[i/N][i%N]==1) list_a.add(i/N*100+i%N);
        }
        for (int i=0; i<N*N; ++i){
            if (B[i/N][i%N]==1) list_b.add(i/N*100+i%N);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : list_a){
            for (int j : list_b){
                map.put(j-i, map.getOrDefault(j-i, 0)+1);
            }
        }
        int max = 0;
        for (Integer val : map.values()){
            max = Math.max(val, max);
        }
        return max;
    }
}
