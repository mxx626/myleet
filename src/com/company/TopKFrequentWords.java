package com.company;

import java.util.*;

// TAG: HashTable, Heap, Trie
public class TopKFrequentWords {
    /**
     * Given a non-empty list of words, return the k most frequent elements.

     Your answer should be sorted by frequency from highest to lowest. If two
     words have the same frequency, then the word with the lower alphabetical
     order comes first.

     Example 1:
     Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     Output: ["i", "love"]
     Explanation: "i" and "love" are the two most frequent words.
     Note that "i" comes before "love" due to a lower alphabetical order.
     Example 2:
     Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     Output: ["the", "is", "sunny", "day"]
     Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
     with the number of occurrence being 4, 3, 2 and 1 respectively.
     Note:
     You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     Input words contain only lowercase letters.
     Follow up:
     Try to solve it in O(n log k) time and O(n) extra space.
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, TrieNode> map = new HashMap<>();
        for (String word : words){
            if (!map.containsKey(word)){
                TrieNode node = add(word, new TrieNode());
                map.put(word, node);
            }
            map.get(word).times++;
        }
        PriorityQueue<TrieNode> pq = new PriorityQueue<>(new Comparator<TrieNode>(){
            @Override
            public int compare(TrieNode root1, TrieNode root2){
                if (root1.times!=root2.times)  return root2.times-root1.times;
                return root1.word.compareTo(root2.word);
            }
        });
        for (TrieNode n : map.values()){
            pq.add(n);

        }
        List<String> res = new LinkedList<>();
        while (k-->0){
            res.add(pq.poll().word);
        }
        return res;
    }
    private TrieNode add(String word1, TrieNode root){
        //  TrieNode cur = root;
        for (char c : word1.toCharArray()){
            if (root.children[c-'a']==null)
                root.children[c-'a']=new TrieNode();
            root = root.children[c-'a'];
        }
        root.word = word1;
        root.times++;
        return root;
    }
    class TrieNode{
        private TrieNode[] children = new TrieNode[26];
        private String word="";
        private int times = 0;
        public TrieNode(){

        }
    }
}
