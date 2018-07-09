package Arrays;
// TAG: Array, Two Pointer
public class ShortestWordDistanceIII {
    /**
     * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

     Given a list of words and two words word1 and word2, return the shortest distance
     between these two words in the list.

     word1 and word2 may be the same and they represent two individual words in the list.

     For example,
     Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

     Given word1 = “makes”, word2 = “coding”, return 1.
     Given word1 = "makes", word2 = "makes", return 3.

     Note:
     You may assume word1 and word2 are both in the list.


     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int first=-1, second=-1, prev=-1, res1 = Integer.MAX_VALUE, res2=Integer.MAX_VALUE;
        for (int i=0; i<words.length; ++i){
            if (words[i].equals(word1)){
                prev=first;
                first=i;
                if (word1.equals(word2) && prev!=-1){
                    res1=Math.min(res1, first-prev);
                }

            }
            else if (words[i].equals(word2)){
                second=i;
            }

            if (first!=-1 && second!=-1){
                res2 = Math.min(res2, Math.abs(second-first));
            }
        }
        return word1.equals(word2) ? res1 : res2;
    }
}
