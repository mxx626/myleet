package DP;
// DP
/**
 * 467. Unique Substrings in Wraparound String

 Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz",
 so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

 Now we have another string p. Your job is to find out how many unique non-empty substrings
 of p are present in s. In particular, your input is the string p and you need to output the
 number of different non-empty substrings of p in the string s.

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
 Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in
 the string s.
 */
public class UniqueSubstringsinWraparoundString {
    public int findSubstringInWraproundString(String p) {
        if (p==null || p.length()==0) return 0;
        int[] count = new int[26];
        count[p.charAt(0)-'a']++;
        int len=1;
        for (int i=1; i<p.length(); ++i){
            int cur = p.charAt(i)-'a';
            int pre = p.charAt(i-1) -'a';
            if ((pre+1)%26==cur){
                len++;
            }
            else len=1;
            count[cur] = Math.max(count[cur], len);
        }
        int sum = 0;
        for (int i : count) sum+=i;
        return sum;
    }
}
