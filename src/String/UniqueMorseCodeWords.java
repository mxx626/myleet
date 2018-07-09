package String;
// String
import java.util.HashSet;
import java.util.Set;

/**
 * 804. Unique Morse Code Words

 International Morse Code defines a standard encoding where each letter is mapped to a series
 of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

 For convenience, the full table for the 26 letters of the English alphabet is given below:

 [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
 ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 Now, given a list of words, each word can be written as a concatenation of the Morse code of
 each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation
 "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

 Return the number of different transformations among all words we have.

 Example:
 Input: words = ["gin", "zen", "gig", "msg"]
 Output: 2
 Explanation:
 The transformation of each word is:
 "gin" -> "--...-."
 "zen" -> "--...-."
 "gig" -> "--...--."
 "msg" -> "--...--."

 There are 2 different transformations, "--...-." and "--...--.".


 Note:

 The length of words will be at most 100.
 Each words[i] will have length in range [1, 12].
 words[i] will only consist of lowercase letters.
 */
public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] dict = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
                ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
                "...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] res = new String[words.length];
        if (words==null || words.length<2) return words.length;
        Set<String> set = new HashSet<>();
        for (int i=0; i<words.length; ++i){
            set.add(helper(words[i], dict));
        }
        return set.size();
    }

    private String helper(String word, String[] dict){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<word.length(); ++i){
            int cur = word.charAt(i)-'a';
            sb.append(dict[cur]);
        }
        return sb.toString();
    }
}
