package HashTable;
// TAG:  HashTable, Design
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {
    /**
     * This is a follow up of Shortest Word Distance. The only difference is now you
     * are given the list of words and your method will be called repeatedly many
     * times with different parameters. How would you optimize it?

     Design a class which receives a list of words in the constructor, and implements
     a method that takes two words word1 and word2 and return the shortest distance
     between these two words in the list.

     For example,
     Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

     Given word1 = “coding”, word2 = “practice”, return 3.
     Given word1 = "makes", word2 = "coding", return 1.

     Note:
     You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
     */
    private Map<String, List<Integer>> map;
    public ShortestWordDistanceII(String[] words) {
        map = new HashMap();
        for (int i=0; i<words.length; ++i){
            map.putIfAbsent(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int i=0, j=0, res = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        while (i<list1.size() && j<list2.size()){
            res = Math.min(res, Math.abs(list1.get(i)-list2.get(j)));
            if (list1.get(i)<list2.get(j)) i++;
            else j++;
        }
        return res;
    }
}
