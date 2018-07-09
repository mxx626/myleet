package com.company;
// Divide Conquer
public class LongestSubstringwithAtLeastKRepeatingCharacters {
    /**
     * Find the length of the longest substring T of a given string (consists of
     * lowercase letters only) such that every character in T appears no less than k times.

     Example 1:

     Input:
     s = "aaabb", k = 3

     Output:
     3

     The longest substring is "aaa", as 'a' is repeated 3 times.
     Example 2:

     Input:
     s = "ababbc", k = 2

     Output:
     5

     The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        return longestSubStr(s.toCharArray(), 0, s.length(), k);
    }
    private int longestSubStr(char[] str, int start, int end, int k){
        if (start-end>k) return 0;
        int[] count = new int[26];
        for (int i=start; i<end; ++i) count[str[i]-'a']++;

        for(int i=start; i<end; ++i){
            if (count[str[i]-'a']<k){
                int j = i+1;
                while (j<end && count[str[j]-'a']<k) j++;
                return Math.max(longestSubStr(str, start, i, k),  longestSubStr(str, j, end, k));
            }
        }
        return end-start;
    }


    public int longestSubstring2(String s, int k) {
        int i = 0, len = s.length(), res = 0;
        while (i+k<=len){
            int[] count = new int[26];
            int mask = 0;
            int max_end=i;
            for (int j=i; j<len; ++j){
                int c = s.charAt(j)-'a';
                count[c]++;
                if (count[c]<k) mask |= (1<<c);
                else if (count[c]>=k) mask &= (~(1<<c));

                if (mask==0){
                    res = Math.max(res, j-i+1);
                    max_end = j;
                }
            }
            i=max_end+1;
        }
        return res;
    }



}
