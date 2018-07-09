package com.company;
// Two Pointer
import java.util.ArrayList;
import java.util.List;

/**
 * 821. Shortest Distance to a Character

 Given a string S and a character C, return an array of integers representing
 the shortest distance from the character C in the string.

 Example 1:

 Input: S = "loveleetcode", C = 'e'
 Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]


 Note:

 S string length is in [1, 10000].
 C is a single character, and guaranteed to be in string S.
 All letters in S and C are lowercase.
 */
public class ShortestDistancetoaCharacter {
    public int[] shortestToChar2(String S, char C) {
        if (S.length()==1) return new int[1];
        int lastC = -1;
        int lastNonC=0;
        int[] res = new int[S.length()];
        for (int i=0; i<S.length(); ++i){
            if (S.charAt(i)==C){
                while (lastNonC <= i){
                    res[lastNonC] = Math.min(res[lastNonC], i-lastNonC++);
                }
                lastC = i;
            }
            else {
                res[i] = lastC==-1 ? Integer.MAX_VALUE : i-lastC;
            }
        }
        return res;
    }

    public int[] shortestToChar(String S, char C) {
        if (S.length()==1) return new int[1];
        Integer[] c_idx = addIndex(S, C);
        int[] res = new int[S.length()];
        for (int i=0; i<S.length(); ++i){
            res[i]=binary(c_idx, 0, c_idx.length-1, i);
        }
        return res;
    }
    private int binary(Integer[] arr, int s, int e, int i){
        while (s<=e){
            int m = s+(e-s)/2;
            if (arr[m]==i) return 0;
            else if (arr[m]>i) e=m-1;
            else s=m+1;
        }
        if (s==0) return arr[0]-i;
        if (s==arr.length) return i-arr[arr.length-1];
        return Math.min(arr[s]-i, i-arr[s-1]);
    }
    private Integer[] addIndex(String s, char c){
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)==c){
                res.add(i);
            }
        }
        Integer[] arr = new Integer[res.size()];
        arr = res.toArray(arr);
        return arr;
    }
}
