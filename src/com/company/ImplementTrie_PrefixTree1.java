package com.company;
// TAG: Design, Trie
public class ImplementTrie_PrefixTree1 {
    /**
     *  Implement a trie with insert, search, and startsWith methods.
     Note:
     You may assume that all inputs are consist of lowercase letters a-z.
      */
    class TrieNode{
        private boolean isWord;
        private static final int N = 26;
        private TrieNode[] children;
        public TrieNode(boolean isWord) {
            this.children = new TrieNode[N];
            this.isWord = isWord;
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public ImplementTrie_PrefixTree1() {
        root=new TrieNode(false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            if (cur.children[c-'a']==null){
                cur.children[c-'a']=new TrieNode (false);
            }
            cur = cur.children[c-'a'];
        }
        cur.isWord=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            if (cur.children[c-'a']==null)
                return false;
            cur=cur.children[c-'a'];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()){
            if (cur.children[c-'a']==null)
                return false;
            cur = cur.children[c-'a'];
        }
        return true;
    }
}
