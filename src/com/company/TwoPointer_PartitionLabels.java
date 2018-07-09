package com.company;

import java.util.ArrayList;
import java.util.List;

public class TwoPointer_PartitionLabels {
    /**
     *  A string S of lowercase letters is given. We want to partition this string
     *  into as many parts as possible so that each letter appears in at most one
     *  part, and return a list of integers representing the size of these parts.
     *  Example 1:
     *  Input: S = "ababcbacadefegdehijhklij"
     *  Output: [9,7,8]
     *  Explanation:
     *  The partition is "ababcbaca", "defegde", "hijhklij".
     *  This is a partition so that each letter appears in at most one part.
     *  A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
     *  splits S into less parts.
     *
     *  Note:
     *  S will have length in range [1, 500].
     *  S will consist of lowercase letters ('a' to 'z') only.
     *  **/
    public List<Integer> partitionLabels(String S) {
        if (S==null || S.length()==0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int last_index[] = new int[26];
        for (int i=0; i<S.length(); ++i){
            last_index[S.charAt(i)-'a']=i;
        }
        int startIdx=0, endIdx=0;
        for (int i=0; i<S.length(); ++i){
            endIdx = Math.max(endIdx, last_index[S.charAt(i)-'a']);
            if (i==endIdx){
                res.add(endIdx-startIdx+1);
                startIdx=endIdx+1;
            }
        }
        return res;
    }
}
