package com.company;

import java.util.*;

public class WordLadder {
    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find the length
     * of shortest transformation sequence from beginWord to endWord, such that:
     * Only one letter can be changed at a time.
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     *
     * For example,
     * Given:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     *
     * Note:
     * Return 0 if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * You may assume no duplicates in the word list.
     * You may assume beginWord and endWord are non-empty and are not the same.
     *
     * UPDATE (2017/1/20):
     * The wordList parameter had been changed to a list of strings (instead of a set of strings).
     * Please reload the code definition to get the latest changes.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word : wordList){
            if (!word.equals(beginWord)){
                set.add(word);
            }
        }
        if (!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        int len = beginWord.length();
        int step=0;
        q.offer(beginWord);
        while (!q.isEmpty()){
            ++step;
            for (int i=q.size(); i>0; --i){
                String word = q.poll();
                char[] ch = word.toCharArray();
                for (int j=0; j<len; ++j){
                    char sel = ch[j];
                    for (char c='a'; c<='z'; ++c){
                        if (c==sel) continue;
                        ch[j]=c;
                        String str = new String(ch);
                        if (str.equals(endWord)) {
                            return step+1;
                        }
                        if (!set.contains(str)){
                            continue;
                        }
                        set.remove(str);
                        q.offer(str);
                    }
                    ch[j]=sel;
                }
            }
        }
        return 0;
    }
    //Bidirection BFS
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word : wordList){
            if (!word.equals(beginWord)){
                set.add(word);
            }
        }
        if (!set.contains(endWord)) return 0;

        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(beginWord);
        endSet.add(endWord);
        int len = beginWord.length();
        int step=0;
        while (!startSet.isEmpty() && !endSet.isEmpty()){
            ++step;
            if (startSet.size() > endSet.size()){
                Set<String> swapSet = startSet;
                startSet=endSet;
                endSet=swapSet;
            }
            Set<String> tmpSet = new HashSet<>();
            for (String word : startSet){
                char[] chars=word.toCharArray();
                for (int i=0; i<len; ++i){
                    char aChar = chars[i];
                    for (char c='a'; c<='z'; ++c){
                        if (c==aChar) continue;
                        chars[i]=c;
                        String t = new String(chars);
                        if (endSet.contains(t)){
                            return step+1;
                        }
                        if (!set.contains(t)){
                            continue;
                        }
                        set.remove(t);
                        tmpSet.add(t);
                    }
                    chars[i]=aChar;
                }
            }
            startSet=tmpSet;
        }
        return 0;
    }
}
