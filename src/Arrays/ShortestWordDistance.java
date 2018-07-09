package Arrays;
//Array
/**
 * 243. Shortest Word Distance

 Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 Example:
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Input: word1 = “coding”, word2 = “practice”
 Output: 3
 Input: word1 = "makes", word2 = "coding"
 Output: 1
 Note:
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int first=-1, second=-1, res=Integer.MAX_VALUE;
        for (int i=0; i<words.length; ++i){
            if (words[i].equals(word1) || words[i].equals(word2)){
                if (first==-1){
                    first = i;
                }
                else if (second==-1){
                    second=i;
                    if (!words[second].equals(words[first])){
                        res = Math.min(res, second-first);
                    }
                }
                else {
                    if (!words[i].equals(words[second])){
                        res = Math.min(res, i-second);
                    }
                    first = second;
                    second=i;
                }
            }
        }
        return res==Integer.MAX_VALUE ? -1 : res;
    }
}
