package com.company;
// TAG: String
public class ExpressiveWords {
    /**
     * Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo",
     * "hi" -> "hiiii".  Here, we have groups, of adjacent letters that are all the same character,
     * and adjacent characters to the group are different.  A group is extended if that group is
     * length 3 or more, so "e" and "o" would be extended in the first example, and "i" would be
     * extended in the second example.  As another example, the groups of "abbcccaaaa" would be "a",
     * "bb", "ccc", and "aaaa"; and "ccc" and "aaaa" are the extended groups of that string.

     For some given string S, a query word is stretchy if it can be made to be equal to S by extending
     some groups.  Formally, we are allowed to repeatedly choose a group (as defined above) of characters
     c, and add some number of the same character c to it so that the length of the group is 3 or more.
     Note that we cannot extend a group of size one like "h" to a group of size two like "hh" - all
     extensions must leave the group extended - ie., at least 3 characters long.

     Given a list of query words, return the number of words that are stretchy.

     Example:
     Input:
     S = "heeellooo"
     words = ["hello", "hi", "helo"]
     Output: 1
     Explanation:
     We can extend "e" and "o" in the word "hello" to get "heeellooo".
     We can't extend "helo" to get "heeellooo" because the group "ll" is not extended.
     Notes:

     0 <= len(S) <= 100.
     0 <= len(words) <= 100.
     0 <= len(words[i]) <= 100.
     S and all words in words consist only of lowercase letters
     * @param S
     * @param words
     * @return
     */
    public int expressiveWords(String S, String[] words) {
        int result = 0;
        for (String word : words) {
            if (match(S, word)) {
                result++;
            }
        }
        return result;
    }

    private boolean match(String S, String word) {
        int i = 0;
        int j = 0;
        while (i < S.length() && j < word.length()) {
            if (S.charAt(i) != word.charAt(j)) {
                return false;
            }
            int count1 = countChar(S, i);
            int count2 = countChar(word, j);
            if (count1 != count2 && (count1 < 3 || count1 < count2)) {
                return false;
            }
            i += count1;
            j += count2;
        }
        return i == S.length() && j == word.length();
    }

    private int countChar(String s, int start) {
        char c = s.charAt(start);
        int i = start + 1;
        for (; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                break;
            }
        }
        return i - start;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public int expressiveWords2(String S, String[] words) {
        int res=0;
        for (String str : words){
            if (isMatch(str, S))
                res++;
        }
        return res;
    }
    private boolean isMatch(String word, String S){
        int wLen=word.length(), sLen=S.length();
        if (wLen>sLen) return false;
        if (wLen==sLen && !word.equals(S)) return false;
        int i=0, j=0;
        boolean flag=true;
        while (i<wLen && j<sLen){
            if (word.charAt(i) == S.charAt(j)){
                int tmp = i;
                int tmpS = j;
                char c = word.charAt(i);
                while (i<wLen && word.charAt(i)==c) i++;
                while (j<sLen && S.charAt(j)==c) j++;
                if (j-tmpS<3 && !word.substring(tmp, i).equals(S.substring(tmpS, j))){
                    flag=false;
                    break;
                }
            }
            else break;
        }
        if (i==wLen && j==sLen && flag) return true;
        return false;
    }
}
