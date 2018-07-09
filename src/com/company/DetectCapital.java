package com.company;
// String
public class DetectCapital {
    /**
     * Given a word, you need to judge whether the usage of capitals in it is right or not.

     We define the usage of capitals in a word to be right when one of the following cases holds:

     All letters in this word are capitals, like "USA".
     All letters in this word are not capitals, like "leetcode".
     Only the first letter in this word is capital if it has more than one letter, like "Google".
     Otherwise, we define that this word doesn't use capitals in a right way.
     Example 1:
     Input: "USA"
     Output: True
     Example 2:
     Input: "FlaG"
     Output: False
     Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        char[] ch = word.toCharArray();
        boolean cap = ch[0]>='A'&&ch[0]<='Z';
        boolean res = false;
        int i=1;
        if (cap){
            res = check(ch);
        }
        else {
            while (i<ch.length){
                if (ch[i]>='a' && ch[i]<='z'){
                    i++;
                    continue;
                }
                else break;
            }
            res = i==ch.length;
        }
        return res;
    }

    private boolean check (char[] ch){
        if (ch.length==1) return true;
        int i=1;
        boolean allCap = ch[1]>='A'&&ch[1]<='Z';
        while (i<ch.length){
            if (allCap && ch[i]>='a' && ch[i]<='z') return false;
            if (!allCap && ch[i]>='A' && ch[i]<='Z') return false;
            i++;
        }
        return true;
    }
}
