package com.company;
public class String_ReverseWordsinaString {
    /**
     * Given an input string, reverse the string word by word.
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     *
     * Update (2015-02-12):
     * For C programmers: Try to solve it in-place in O(1) space.
     *
     * click to show clarification.
     * Clarification:
     * What constitutes a word?
     * A sequence of non-space characters constitutes a word.
     * Could the input string contain leading or trailing spaces?
     * Yes. However, your reversed string should not contain leading or trailing spaces.
     * How about multiple spaces between two words?
     * Reduce them to a single space in the reversed string.
     */
    public String reverseWords(String s) {
        if (s==null || s.length()==0) return s;
        String arr[] = s.trim().split("\\s+");
        String res="";
        for (int i=arr.length-1; i>=0; --i){
            res+=arr[i]+" ";
        }
        return res.trim();
    }

    public String reverseWords1(String s){
        if (s==null || s.length()==0) return s;
        String arr[] = s.split(" ");
        String res="";
        for (int i=arr.length-1; i>=0; --i){
            if (!arr[i].equals(" ")){
                res+=arr[i]+" ";
            }
        }
        return res.substring(0, res.length()-1);
    }
}
