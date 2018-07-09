package com.company;
// String

import java.util.Arrays;
import java.util.Comparator;

/**
 * 820. Short Encoding of Words

 Given a list of words, we may encode it by writing a reference string S and a list of indexes A.

 For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#"
 and indexes = [0, 2, 5].

 Then for each index, we will recover the word by reading from the reference string from that index
 until we reach a "#" character.

 What is the length of the shortest reference string S possible that encodes the given words?

 Example:

 Input: words = ["time", "me", "bell"]
 Output: 10
 Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 Note:

 1 <= words.length <= 2000.
 1 <= words[i].length <= 7.
 Each word has only lowercase letters.
 */
public class ShortEncodingofWords {
    class Node {
        Node[] child = new Node[26];
        public Node(){

        }
    }
    public boolean add(String word){
        boolean newWord = false;
        Node node = root;
        for (char c : new StringBuilder(word).reverse().toString().toCharArray()){
            if (node.child[c-'a']==null){
                node.child[c-'a']=new Node();
                newWord = true;
            }
            node = node.child[c-'a'];
        }
        return newWord;
    }
    public int minimumLengthEncoding(String[] words) {
        Comparator<String> myComparator = new Comparator<String>(){
            @Override
            public int compare (String s1, String s2){
                return s2.length()-s1.length();
            }
        };
        Arrays.sort(words, myComparator);
        int len = 0;
        for (int i=0; i<words.length; ++i){
            if (add(words[i])){
                len+=words[i].length()+1;
            }
        }
        return len;
    }
    private Node root = new Node();
}
