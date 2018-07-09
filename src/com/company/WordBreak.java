package com.company;
// DP
import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list
 * of non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words. You may assume the dictionary
 * does not contain duplicate words.
 *
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of
 * a set of strings). Please reload the code definition to get the latest changes.
 *      l   e   e   t    c    o     d     e
 *  dp  0   0   0   1    1    1     1     2
 * **/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len=s.length();
        if(len==1) return wordDict.contains(s);
        boolean dp[] = new boolean[len+1];
        dp[0]=true;
        for (int i=1; i<=len; ++i){
            for (int j=0; j<i; ++j){
                if (dp[j]&&wordDict.contains(s.substring(j, i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
