package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DP_UniqueSubstringsinWraparoundString {
    /**
     *Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz",
     * so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

     Now we have another string p. Your job is to find out how many unique non-empty substrings of
     p are present in s. In particular, your input is the string p and you need to output the number
     of different non-empty substrings of p in the string s.

     Note: p consists of only lowercase English letters and the size of p might be over 10000.

     Example 1:

     Input: "a"
     Output: 1

     Explanation: Only the substring "a" of string "a" is in the string s.

     Example 2:

     Input: "cac"
     Output: 2
     Explanation: There are two substrings "a", "c" of string "cac" in the string s.

     Example 3:

     Input: "zab"
     Output: 6
     Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.

     * **/
    private static final char[] pattern = new char[]{
            'a','b','c','d','e','f','g','h','i','j',
            'k','l','m','n','o','p','q','r','s','t',
            'u','v','w','x','y','z'
    };
    // TLE
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[p.length()+1];
      //  HashSet<Integer> set = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        for (int i=1; i<=p.length(); ++i){
       //     int num = 1<<(p.charAt(i-1)-'a');
            if (!set.contains(String.valueOf(p.charAt(i-1)))) {
                set.add(String.valueOf(p.charAt(i-1)));
                dp[i]=1;
            }
            dp[i] += dp[i-1];
            int count=0;
            for (int j=i-1; j>=0; --j){
                if (contains(p.substring(j, i))){
                    if (!set.contains(p.substring(j, i))){
                        set.add(p.substring(j, i));
                        count++;
                    }
                }
                else break;
            }
            dp[i] += count;
        }
        return dp[p.length()];
    }
    private boolean contains (String substring){
        char[] ch = substring.toCharArray();
        int startIdx = ch[0]-'a';
        for (int i=0; i<ch.length; ++i){
            if (ch[i]=='z' && ch[i]==pattern[startIdx]){
                startIdx=0;
            }
            else if (ch[i]!='z' && ch[i]==pattern[startIdx++])continue;
            else return false;
        }
        return true;
    }

    // Simplfied version
    // count[i] is the maximum unique substring end with ith letter.
    // 0 - 'a', 1 - 'b', ..., 25 - 'z'.
    public int findSubstringInWraproundString1(String p){
        int[] count = new int[26];
        if (p==null || p.length()==0) return 0;
        int maxLengthEndWith =0;
        for (int i=0; i<p.length(); ++i){
            if (i>0 && (p.charAt(i)-p.charAt(i-1)==1 || p.charAt(i-1)-p.charAt(i)==25)){
                maxLengthEndWith++;
            }
            else {
                maxLengthEndWith=1;
            }
            int idx = p.charAt(i)-'a';
            count[idx] = Math.max(count[idx], maxLengthEndWith);
        }
        int sum =0;
        for (int i=0; i<26; i++){
            sum+=count[i];
        }
        return sum;
    }
}
