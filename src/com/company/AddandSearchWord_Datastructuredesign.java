package com.company;
// Design
/**
 *
 * 211. Add and Search Word - Data structure design
 *
 *
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 Example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 */
public class AddandSearchWord_Datastructuredesign {
    class TrieNode {
        private TrieNode[] children;
        private boolean isWord;
        public TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public AddandSearchWord_Datastructuredesign() {
        root = new TrieNode();
    }
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            if (cur.children[c-'a']==null){
                cur.children[c-'a']= new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isWord=true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode cur = root;
        return searchSubstring(word, cur);
    }
    private boolean searchSubstring(String word, TrieNode root){
        if (root==null) return false;
        TrieNode cur = root;
        for (int i=0; i<word.length(); ++i){
            char c = word.charAt(i);
            if (c=='.'){
                for (TrieNode next : cur.children){
                    if (next==null) continue;
                    if (searchSubstring(word.substring(i+1), next)) return true;
                }
                return false;
            }
            if (cur.children[c-'a']==null) return false;
            cur = cur.children[c-'a'];
        }
        return cur.isWord;
    }
}
