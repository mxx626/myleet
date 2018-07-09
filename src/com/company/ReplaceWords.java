package com.company;
// TAGL HashTable, Trie
import java.util.List;

public class ReplaceWords {
    /**
     *  In English, we have a concept called root, which can be followed by some other words
     *  to form another longer word - let's call this word successor. For example, the root
     *  an, followed by other, which can form another word another.

     Now, given a dictionary consisting of many roots and a sentence. You need to replace all
     the successor in the sentence with the root forming it. If a successor has many roots can
     form it, replace it with the root with the shortest length.

     You need to output the sentence after the replacement.

     Example 1:

     Input: dict = ["cat", "bat", "rat"]
     sentence = "the cattle was rattled by the battery"
     Output: "the cat was rat by the bat"

     Note:

     The input will only have lower-case letters.
     1 <= dict words number <= 1000
     1 <= sentence words number <= 1000
     1 <= root length <= 100
     1 <= sentence words length <= 1000
     */
    class TrieNode{
        private TrieNode[] children = new TrieNode[26];
        private String word;
    }
    private void addWord (String word){
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            if (cur.children[c-'a']==null)
                cur.children[c-'a']=new TrieNode();
            cur=cur.children[c-'a'];
        }
        cur.word = new String(word);
    }
    private String searchWord(String word){
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            if (cur.children[c-'a']==null) break;
            if (cur.children[c-'a'].word != null){
                return cur.children[c-'a'].word;
            }
            cur = cur.children[c-'a'];
        }
        return cur.word==null ? word : cur.word;
    }
    private TrieNode root = new TrieNode();
    public String replaceWords(List<String> dict, String sentence) {
        for (String word : dict){
            addWord(new String(word));
        }
        StringBuilder sb = new StringBuilder();
        for (String str : sentence.split("\\s+")){
            sb.append(searchWord(str)+" ");
        }
        return sb.toString().substring(0,sb.length()-1);
    }
}
