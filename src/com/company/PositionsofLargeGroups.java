package com.company;
// Two Pointer

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsofLargeGroups {
    /**
     * In a string S of lowercase letters, these letters form consecutive groups of the same character.

     For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

     Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

     The final answer should be in lexicographic order.



     Example 1:

     Input: "abbxxxxzzy"
     Output: [[3,6]]
     Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
     Example 2:

     Input: "abc"
     Output: []
     Explanation: We have "a","b" and "c" but no large group.
     Example 3:

     Input: "abcdddeeeeaabbbcd"
     Output: [[3,5],[6,9],[12,14]]
     * @param S
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = S.length(); // i is the start of each group
        for (int j = 0; j < N; ++j) {
            if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
                // Here, [i, j] represents a group.
                if (j-i+1 >= 3)
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                i = j + 1;
            }
        }

        return ans;
    }

    public List<List<Integer>> largeGroupPositions2(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S==null || S.length()<3) return res;
        int idx=0;
        char pre = S.charAt(0);
        int count=1;
        for (int i=1; i<S.length(); ++i){
            char cur = S.charAt(i);
            if (cur!=pre){
                if (count>=3){
                    List<Integer> arr = new ArrayList<>();
                    arr.add(idx);
                    arr.add(i-1);
                    res.add(arr);
                }
                count=1;
                idx=i;
                pre=cur;
            }
            else {
                count++;
            }
        }
        if (count>=3){
            List<Integer> arr = new ArrayList<>();
            arr.add(idx);
            arr.add(S.length()-1);
            res.add(arr);
        }
        return res;
    }
}
