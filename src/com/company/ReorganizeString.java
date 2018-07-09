package com.company;

import java.util.PriorityQueue;

// TAG: String, Heap, Sort, Greedy
public class ReorganizeString {
    /**
     * Given a string S, check if the letters can be rearranged so that two
     * characters that are adjacent to each other are not the same.

     If possible, output any possible result.  If not possible, return the empty string.

     Example 1:

     Input: S = "aab"
     Output: "aba"
     Example 2:

     Input: S = "aaab"
     Output: ""
     Note:

     S will consist of lowercase letters and have length in range [1, 500].
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        int[] count = new int[26];
        int max=0;
        for (char c : S.toCharArray()){
            ++count[c-'a'];
            if (count[c-'a']>count[max]){
                max=c-'a';
            }
        }
        int len=S.length();
        if (len<2*count[max]-1) return "";
        int idx=0;
        char[] res = new char[len];
        for (int i=0; i<count[max]; ++i){
            res[idx]=((char)(max+'a'));
            idx += 2;
        }
        count[max]=0;
        for (int i=0; i<26; ++i){
            char cur = (char)(i+'a');
            while (count[i]>0){
                if (idx>=len) idx=1;
                res[idx]=cur;
                idx += 2;
                count[i]--;
            }
        }
        return new String(res);
    }

    public String reorganizeString2(String S) {
        char[] alphabet = new char[26];
        for (char c : S.toCharArray()) {
            alphabet[c - 'a']++;
            if (alphabet[c - 'a'] > (S.length() + 1) / 2) {
                return "";
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > 0) {
                pq.add(new int[] {i + 97, alphabet[i]});
            }
        }

        StringBuffer ans = new StringBuffer();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (ans.length() == 0 || first[0] != ans.charAt(ans.length() -1)) {
                ans.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                ans.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return ans.toString();
    }
}
