package DFSorBFS;
// BFS
import java.util.HashSet;
import java.util.List;

public class WordLadder {
    /**
     *Given two words (beginWord and endWord), and a dictionary's word list, find the length
     * of shortest transformation sequence from beginWord to endWord, such that:

     Only one letter can be changed at a time.
     Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     Note:

     Return 0 if there is no such transformation sequence.
     All words have the same length.
     All words contain only lowercase alphabetic characters.
     You may assume no duplicates in the word list.
     You may assume beginWord and endWord are non-empty and are not the same.
     Example 1:

     Input:
     beginWord = "hit",
     endWord = "cog",
     wordList = ["hot","dot","dog","lot","log","cog"]

     Output: 5

     Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     return its length 5.
     Example 2:

     Input:
     beginWord = "hit"
     endWord = "cog"
     wordList = ["hot","dot","dog","lot","log"]

     Output: 0

     Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Time Complexity: O(n*26^l) -> O(n*26^l/2), l = len(word), n=|wordList|      Space Complexity: O(n)
        // Put all the word into the set, except the word equals beginword, otherwise, it will probably do one more step
        HashSet<String> set = new HashSet<>();
        for (String word : wordList) {
            if (word.equals(beginWord)) continue;
            set.add(word);
        }
        if (!set.contains(endWord)) return 0;

        // Use set1 to store the word begrin from begin word
        // Set 2 to store the word begin from the end word
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        set1.add(beginWord);
        set2.add(endWord);
        int len = beginWord.length();
        int step = 0;


        while (!set1.isEmpty() && !set2.isEmpty()) {
            ++step;
            // if set 1 bigger than set 2 size, swap them. It will optimize the algo
            if (set1.size() > set2.size()) {
                HashSet<String> swap = set1;
                set1 = set2;
                set2 = swap;
            }
            HashSet<String> tmp = new HashSet<>();
            for (String word : set1) {
                // get the word from set, change the word char one by one.
                char[] ch = word.toCharArray();
                for (int i = 0; i < len; ++i) {
                    char tmpChar = ch[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == tmpChar) continue;
                        ch[i] = c;
                        String str = new String(ch);
                        if (set2.contains(str)) return step + 1; // if the word contains in set 2.  Will return step+1.
                        if (!set.contains(str)) continue;
                        set.remove(str); // if set contains this word, remove it because we do not need to use it.
                        tmp.add(str); // add it to the tmp set and set it to the start set at the end
                    }
                    ch[i] = tmpChar; // change back to the original word.
                }
            }
            set1 = tmp;
        }
        return 0;
    }
}
