package com.company;
// TAG: Sort, Two POinter
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestWordinDictionarythroughDeleting {
    /**
     *  Given a string and a string dictionary, find the longest string in the dictionary
     *  that can be formed by deleting some characters of the given string. If there are
     *  more than one possible results, return the longest word with the smallest
     *  lexicographical order. If there is no possible result, return the empty string.

     Example 1:

     Input:
     s = "abpcplea", d = ["ale","apple","monkey","plea"]

     Output:
     "apple"

     Example 2:

     Input:
     s = "abpcplea", d = ["a","b","c"]

     Output:
     "a"

     Note:

     All the strings in the input will only contain lower-case letters.
     The size of the dictionary won't exceed 1,000.
     The length of all the strings in the input won't exceed 1,000.

     * @param s
     * @param d
     * @return
     */
    public String findLongestWord1(String s, List<String> d) {
        String res = "";
        for (String str : d){
            if (isMatch2(str, s) && isBetter(str, res)){
                res = str;
            }
        }
        return res;
    }
    private boolean isBetter (String str1, String str2){
        if (str1.length()>str2.length() || (str1.length()==str2.length() && str1.compareTo(str2)<0)) return true;
        return false;
    }
    private boolean isMatch2(String str, String s){
        int start=-1;
        for (int i=0; i<str.length(); ++i){
            start = s.indexOf(str.charAt(i), start+1);
            if (start<0) return false;
        }
        return true;
    }


    /////////////////////////////////////////////////////////////////////////////
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if (o1.length()!=o2.length()) return o2.length()-o1.length();
                return o1.compareTo(o2);
            }
        });
        for (String str : d){
            if (isMatch(str, s)) return str;
        }
        return "";
    }
    private boolean isMatch(String str, String s){
        int lstr=0, ls=0;
        while (lstr<str.length() && ls<s.length()){
            if (s.charAt(ls)==str.charAt(lstr)) lstr++;
            ls++;
        }
        return lstr==str.length();
    }
}
