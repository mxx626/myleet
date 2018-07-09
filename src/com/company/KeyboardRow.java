package com.company;
// String, HashTable
import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {
    /**
     * Given a List of words, return the words that can be typed using
     * letters of alphabet on only one row's of American keyboard like the image below.


     American keyboard


     Example 1:
     Input: ["Hello", "Alaska", "Dad", "Peace"]
     Output: ["Alaska", "Dad"]
     Note:
     You may use one character in the keyboard more than once.
     You may assume the input string will only contain letters of alphabet.

     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        List<String> map = new ArrayList<>();
        map.add("QqWwEeRrTtYyUuIiOoPp");
        map.add("AaSsDdFfGgHhJjKkLl");
        map.add("ZzXxCcVvBbNnMm");
        List<String> res = new ArrayList<>();
        for (String word : words){
            if (valid(map, word)){
                res.add(word);
            }
        }
        int size = res.size();
        String[] ret = new String[size];
        for (int i=0; i<size; ++i) ret[i]=res.get(i);
        return ret;
    }
    private boolean valid(List<String> map , String str){
        int index = 0;
        for (int i=0; i<map.size(); ++i){
            if (map.get(i).indexOf(str.charAt(0))!=-1){
                index = i;
                break;
            }
        }

        for (char c : str.toCharArray()){
            if (map.get(index).indexOf(c)==-1)
                return false;
        }
        return true;
    }
}
