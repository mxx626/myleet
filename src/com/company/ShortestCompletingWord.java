package com.company;

import java.util.Arrays;

public class ShortestCompletingWord {
    /**
     *  Find the minimum length word from a given dictionary words, which has all the letters
     *  from the string licensePlate. Such a word is said to complete the given string licensePlate

     Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

     It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

     The license plate might have the same letter occurring multiple times. For example, given
     a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

     Example 1:

     Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
     Output: "steps"
     Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
     Note that the answer is not "step", because the letter "s" must occur in the word twice.
     Also note that we ignored case for the purposes of comparing whether a letter exists in the word.

     Example 2:

     Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
     Output: "pest"
     Explanation: There are 3 smallest length words that contains the letters "s".
     We return the one that occurred first.

     Note:

     licensePlate will be a string with length in range [1, 7].
     licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
     words will have a length in the range [10, 1000].
     Every words[i] will consist of lowercase letters, and have length in range [1, 15].

     * @param licensePlate
     * @param words
     * @return
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] map = new int[128];
        String str = words[0];
        int res=0;
        for (char c : licensePlate.toCharArray()){
            if (c>=65 && c<=90){
                map[c+32]++;
            }
            else map[c]++;
        }
        // System.out.println(map['s']);
        for (String word : words){
            int tmp = isMatch(word.toCharArray(), map);
            if (tmp > res){
                res=tmp;
                str=new String(word);
            }
            else if (tmp==res){
                str = str.length()>word.length() ? word : str;
            }
        }
        return str;
    }
    private int isMatch (char[] word, int[] map){
        int[] tmp = Arrays.copyOf(map, map.length);
        int res=0;
        for (char c : word){
            if (c>=65 && c<=90) c+=32;
            if (tmp[c] > 0){
                res++;
                tmp[c]--;
            }
        }
        // System.out.println(res);
        return res;
    }
}
