package DP;
// DP, UF, BFS
import java.util.List;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
     * determine if s can be segmented into a space-separated sequence of one or more dictionary words.

     Note:

     The same word in the dictionary may be reused multiple times in the segmentation.
     You may assume the dictionary does not contain duplicate words.
     Example 1:

     Input: s = "leetcode", wordDict = ["leet", "code"]
     Output: true
     Explanation: Return true because "leetcode" can be segmented as "leet code".
     Example 2:

     Input: s = "applepenapple", wordDict = ["apple", "pen"]
     Output: true
     Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     Note that you are allowed to reuse a dictionary word.
     Example 3:

     Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     Output: false

     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        HashSet<String> set = new HashSet<>();
        int max = 0;
        for (String string : wordDict){
            set.add(string);
            if (max<string.length()) max = string.length();
        }
        for (int i=1; i<s.length()+1; ++i){
            dp[i]=false;
            for (int j=1; j<=max&&j<i; ++j){
                String str = s.substring(i-j,i);
                if (set.contains(str)){
                    dp[i] = dp[i-j];
                }
                if (dp[i]) break;
            }
        }
        return dp[s.length()];
    }
}
