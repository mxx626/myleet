package Arrays;
// TAG: Array, Letter Pointer
import java.util.LinkedList;
import java.util.Queue;

public class NumberofMatchingSubsequences {
    /**
     * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

     Example :
     Input:
     S = "abcde"
     words = ["a", "bb", "acd", "ace"]
     Output: 3
     Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".

     Note:

     All words in words and S will only consists of lowercase letters.
     The length of S will be in the range of [1, 50000].
     The length of words will be in the range of [1, 5000].
     The length of words[i] will be in the range of [1, 50].

     * @param S
     * @param words
     * @return
     */
    public int numMatchingSubseq(String S, String[] words) {
        Queue<String>[] map = new LinkedList[26];
        for (int i=0; i<26; ++i){
            map[i] = new LinkedList<>();
        }

        for (String word : words){
            char init = word.charAt(0);
            map[init-'a'].add(word);
        }

        int count=0;
        for (char c : S.toCharArray()){
            Queue<String> sub = map[c-'a'];
            int size = sub.size();
            for (int i=0; i<size; ++i){
                String cur = sub.poll();
                if (cur.length()==1) count++;
                else {
                    map[cur.charAt(1)-'a'].add(cur.substring(1));
                }
            }
        }
        return count;
    }
}

