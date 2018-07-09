package com.company;
// Bitwise
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share
 * common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 *
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 *
 * Example 2:
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 *
 * Example 3:
 * Given ["a", "aa", "aaa", "aaaa"]
 * Return 0
 * No such pair of words.
 * **/
public class MaximumProductofWordLengths1 {

    public int maxProduct1(String[] words) {
        if (words.length==0 || words==null) return 0;
        int[] bytes = new int[words.length];
        int res=0;
        for (int i=0; i<words.length; ++i){
            int val=0;
            for (int j=0; j<words[i].length(); ++j){
                val |= 1<<(words[i].charAt(j)-'a');
            }
            bytes[i]=val;
        }
        for (int i=0; i<words.length-1; ++i){
            for (int j=i+1; j<words.length; ++j){
                if ((bytes[i]&bytes[j])==0){
                    res=Math.max(res, words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }




    public int maxProduct(String[] words) {
        int res=0;
        for (int i=0; i<words.length-1; ++i){
            Map<Character, Character> map = new HashMap<>();
            for (int j=0; j<words[i].length(); ++j){
                if (j == words[i].length()-1){
                    map.put(words[i].charAt(j), '#');
                }
                else map.put(words[i].charAt(j), words[i].charAt(j+1));;

            }
            for (int k=i+1; k<words.length; ++k){
                for (int l=0; l<words[k].length(); ++l){
                    if (!map.containsKey(words[k].charAt(l)) && l==words[k].length()-1) {
                        res = Math.max(res, words[i].length()*words[k].length());
                    }
                    else if (!map.containsKey(words[k].charAt(l))){
                        continue;
                    }
                    else break;
                }
            }
        }
        return res;
    }
}
