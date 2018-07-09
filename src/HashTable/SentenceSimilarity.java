package HashTable;
// HashTable
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarity {
    /**
     * Given two sentences words1, words2 (each represented as an array of strings),
     * and a list of similar word pairs pairs, determine if two sentences are similar.

     For example, "great acting skills" and "fine drama talent" are similar, if the
     similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].

     Note that the similarity relation is not transitive. For example, if "great" and
     "fine" are similar, and "fine" and "good" are similar, "great" and "good" are not
     necessarily similar.

     However, similarity is symmetric. For example, "great" and "fine" being similar
     is the same as "fine" and "great" being similar.

     Also, a word is always similar with itself. For example, the sentences words1 = [
     "great"], words2 = ["great"], pairs = [] are similar, even though there are no
     specified similar word pairs.

     Finally, sentences can only be similar if they have the same number of words.
     So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

     Note:

     The length of words1 and words2 will not exceed 1000.
     The length of pairs will not exceed 2000.
     The length of each pairs[i] will be 2.
     The length of each words[i] and pairs[i][j] will be in the range [1, 20].
     * @param words1
     * @param words2
     * @param pairs
     * @return
     */
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length!=words2.length) return false;
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] p : pairs){
            if (!map.containsKey(p[0])){
                map.put(p[0], new HashSet<>());
            }
            if (!map.containsKey(p[1])){
                map.put(p[1], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
            map.get(p[1]).add(p[0]);
        }

        for (int i=0; i<words1.length; ++i){
            String s1 = words1[i];
            String s2 = words2[i];
            if (s1.equals(s2)) continue;
            if (!map.containsKey(s1) || !map.get(s1).contains(s2)) return false;
        }
        return true;
    }
}
