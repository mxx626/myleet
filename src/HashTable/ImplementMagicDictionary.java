package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementMagicDictionary {
    Map<Integer, List<String>> map;
    /** Initialize your data structure here. */
    public ImplementMagicDictionary(int x) {
        map = new HashMap();
    }

    /** Build a dictionary through a list of words */
    public void buildDict1(String[] dict) {
        for (String word : dict){
            int len = word.length();
            map.putIfAbsent(len, new ArrayList<>());
            map.get(len).add(word);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search1(String word) {
        int len = word.length();
        if (!map.containsKey(len)) return false;
        for (String str : map.get(len)){
            int count=0;
            if (str.equals(word)) continue;
            for (int i=0; i<str.length(); ++i){
                if (word.charAt(i)!=str.charAt(i)){
                    count++;
                }
                if (count>1) break;
            }
            if (count==1) return true;
        }
        return false;
    }



    //////////////////////////////////////////////////////////////////////////////////
    class TrieNode {
        private TrieNode[] children;
        private boolean isWord;
        public TrieNode(){
            children = new TrieNode[26];
            isWord=false;
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public ImplementMagicDictionary() {
        root = new TrieNode();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict){
            TrieNode cur = root;
            for (char c : word.toCharArray()){
                if (cur.children[c-'a']==null){
                    cur.children[c-'a']=new TrieNode();
                }
                cur = cur.children[c-'a'];
            }
            cur.isWord=true;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] ch = word.toCharArray();
        int modify = 0;
        for (int i=0; i<ch.length; ++i){
            for (char j='a'; j<='z'; ++j){
                char tmp = ch[i];
                if (tmp==j) continue;
                ch[i] = j;
                if (searchWord(ch)) return true;
                ch[i] = tmp;
            }
        }
        return false;
    }

    public boolean searchWord (char[] ch){
        TrieNode cur = root;
        for (char c : ch){
            if (cur.children[c-'a']==null){
                return false;
            }
            cur = cur.children[c-'a'];
        }
        return cur.isWord;
    }
}
