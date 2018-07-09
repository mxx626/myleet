package com.company;
// DFS, UF
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SentenceSimilarityII {
    HashMap<String, List<String>> map = new HashMap<>();

    /**
     * Given two sentences words1, words2 (each represented as an array of strings), and a list of
     * similar word pairs pairs, determine if two sentences are similar.

     For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are
     similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"],
     ["acting","drama"], ["skills","talent"]].

     Note that the similarity relation is transitive. For example, if "great" and "good" are similar,
     and "fine" and "good" are similar, then "great" and "fine" are similar.

     Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine"
     and "great" being similar.

     Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2
     = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.

     Finally, sentences can only be similar if they have the same number of words. So a sentence like
     words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

     Note:

     The length of words1 and words2 will not exceed 1000.
     The length of pairs will not exceed 2000.
     The length of each pairs[i] will be 2.
     The length of each words[i] and pairs[i][j] will be in the range [1, 20].
     * @param words1
     * @param words2
     * @param pairs
     * @return
     */
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length!=words2.length) return false;
        for (String[] pair : pairs){
            String s1 = pair[0];
            String s2 = pair[1];
            if (!map.containsKey(s1)) map.put(s1, new ArrayList<>());
            if (!map.containsKey(s2)) map.put(s2, new ArrayList<>());
            map.get(s1).add(s2);
            map.get(s2).add(s1);
        }
        for (int i=0; i<words1.length; ++i){
            String w1 = words1[i];
            String w2 = words2[i];
            if (w1.equals(w2)) continue;
            if (!map.containsKey(w1)) return false;
            if (!helper(w1, w2, new HashSet<String>())) return false;
        }
        return true;
    }

    private boolean helper(String w1, String w2, HashSet<String> visit){
        if(map.get(w1).contains(w2)) return true;
        visit.add(w1);
        for (String word : map.get(w1)){
            if (!visit.contains(word) && helper(word, w2, visit))
                return true;
        }
        return false;
    }


    HashMap<String, String> map1 = new HashMap<>();
    public boolean areSentencesSimilarTwo2(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length!=words2.length) return false;
        for (String[] pair : pairs){
            String s1 = find(pair[0]);
            String s2 = find(pair[1]);
            if (!s1.equals(s2)){
                map1.put(s1,s2);
            }
        }
        for (int i=0; i<words1.length; ++i){
            if (!find(words1[i]).equals(find(words2[i])))
                return false;
        }
        return true;
    }

    private String find(String word){
        if(!map1.containsKey(word)){
            map1.put(word,word);
            return word;
        }
        while(map1.get(word) != word){
            map1.put(word, map1.get(map1.get(word)));
            word = map1.get(word);
        }
        return word;
    }
}
