package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TAG: HashTable, Trie
public class ImplementMagicDictionary {
    /**
     *  Implement a magic directory with buildDict, and search methods.

     For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

     For the method search, you'll be given a word, and judge whether if you modify exactly one c
     haracter into another character in this word, the modified word is in the dictionary you just built.

     Example 1:

     Input: buildDict(["hello", "leetcode"]), Output: Null
     Input: search("hello"), Output: False
     Input: search("hhllo"), Output: True
     Input: search("hell"), Output: False
     Input: search("leetcoded"), Output: False

     Note:

     You may assume that all the inputs are consist of lowercase letters a-z.
     For contest purpose, the test data is rather small by now. You could think about highly
     efficient algorithm after the contest.
     Please remember to RESET your class variables declared in class MagicDictionary, as static/class
     variables are persisted across multiple test cases. Please see here for more details.

     */
    /** Initialize your data structure here. */
    class TrieNode{
        private static final int N=26;
        private boolean isWord;
        private TrieNode[] children;
        public TrieNode (){
            this.isWord = false;
            this.children = new TrieNode[N];
        }
    }
    /** Initialize your data structure here. */
    private TrieNode root = new TrieNode();

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict){
            TrieNode cur = root;
            for (char c : word.toCharArray()){
                if (cur.children[c-'a']==null){
                    cur.children[c-'a'] = new TrieNode();
                }
                cur=cur.children[c-'a'];
            }
            cur.isWord = true;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] ch = word.toCharArray();
        for (int i=0; i<ch.length; ++i){
            for (char c='a'; c<='z'; ++c){
                if (ch[i]==c) continue;
                char org = ch[i];
                ch[i]=c;
                if (match(ch)){
                    return true;
                }
                ch[i]=org;
            }
        }
        return false;
    }
    private boolean match(char[] word){
        TrieNode cur = root;
        for (char c : word){
            if (cur.children[c-'a']==null){
                return false;
            }
            cur=cur.children[c-'a'];
        }
        return cur.isWord;
    }

    //Solution 2

    private HashMap<String, List<int[]>> map;
    public ImplementMagicDictionary() {
        map = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict1(String[] dict) {
        for (String word : dict){
            for (int i=0; i<word.length(); ++i){
                String key = word.substring(0,i)+word.substring(i+1);
                int[] pairs = new int[]{i, word.charAt(i)};
                List<int[]> value = map.getOrDefault(key, new ArrayList<int[]>());
                value.add(pairs);
                map.put(key, value);
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search1(String word) {
        for (int i=0; i<word.length(); ++i){
            String key = word.substring(0,i)+word.substring(i+1);
            if (map.containsKey(key)){
                for (int[] val : map.get(key)){
                    if (i==val[0] && val[1]!=word.charAt(i)) return true;
                }
            }
        }
        return false;
    }
}
