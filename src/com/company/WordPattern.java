package com.company;
// String
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * iven a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length!=pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i=0; i<words.length; ++i){
            char key = pattern.charAt(i);
            if (!map.containsKey(key)){
                if (!set.add(words[i])) return false;
                map.put(key, words[i]);
            }
            else if (!map.get(key).equals(words[i])) return false;
        }
        return true;
    }
}
