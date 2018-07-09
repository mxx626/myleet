package com.company;
// Trie
/**
 * 677. Map Sum Pairs

 Implement a MapSum class with insert, and sum methods.

 For the method insert, you'll be given a pair of (string, integer). The string represents
 the key and the integer represents the value. If the key already existed, then the original
 key-value pair will be overridden to the new one.

 For the method sum, you'll be given a string representing the prefix, and you need to return
 the sum of all the pairs' value whose key starts with the prefix.

 Example 1:
 Input: insert("apple", 3), Output: Null
 Input: sum("ap"), Output: 3
 Input: insert("app", 2), Output: Null
 Input: sum("ap"), Output: 5
 */
public class MapSumPairs {
    class TrieNode{
        TrieNode[] child = new TrieNode[26];
        int val = 0;
        boolean isWord = false;
        public TrieNode (){

        }
    }
    TrieNode root = new TrieNode();
    /** Initialize your data structure here. */
    public MapSumPairs() {

    }

    public void insert(String key, int val) {
        boolean find = search(key);
        TrieNode cur = root;
        for (char c : key.toCharArray()){
            if (cur.child[c-'a']==null) {
                cur.child[c-'a']= new TrieNode();
            }
            if (find){
                cur.child[c-'a'].val=val;
            }
            else cur.child[c-'a'].val+=val;
            cur=cur.child[c-'a'];
        }
        cur.isWord = true;
    }

    public int sum(String prefix) {
        int sum=0;
        TrieNode cur = root;
        for (char c : prefix.toCharArray()){
            if (cur.child[c-'a']==null) return 0;
            cur=cur.child[c-'a'];
            sum = cur.val;
        }
        return sum;
    }
    private boolean search(String word){
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            if (cur.child[c-'a']==null) return false;
            cur = cur.child[c-'a'];
        }
        return cur.isWord;
    }
}
