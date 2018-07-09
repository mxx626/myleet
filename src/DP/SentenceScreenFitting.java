package DP;
// DP
public class SentenceScreenFitting {
    /**
     * Given a rows x cols screen and a sentence represented by a list
     * of non-empty words, find how many times the given sentence can be fitted on the screen.

     Note:

     A word cannot be split into two lines.
     The order of words in the sentence must remain unchanged.
     Two consecutive words in a line must be separated by a single space.
     Total words in the sentence won't exceed 100.
     Length of each word is greater than 0 and won't exceed 10.
     1 ≤ rows, cols ≤ 20,000.
     * @param sentence
     * @param rows
     * @param cols
     * @return
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuilder sb = new StringBuilder();
        for (String word : sentence) sb.append(word+" ");
        String str = sb.toString();
        int start=0, len = str.length();
        for (int i=0; i<rows; ++i){
            start += cols;
            if (str.charAt(start%len)==' '){
                start++;
            }
            else {
                while (start>0 && str.charAt((start-1)%len)!=' '){
                    start--;
                }
            }
        }
        return start/len;
    }
}
