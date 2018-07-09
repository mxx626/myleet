package com.company;
// Two Pointer, String
/**
 * 345. Reverse Vowels of a String

 Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 */
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        String str = "AEIOUaeiou";
        char[] arr = s.toCharArray();
        int i=0, j=s.length()-1;
        while (i<j){
            while (i<s.length() && str.indexOf(arr[i])==-1) i++;
            while (j>=0 && str.indexOf(arr[j])==-1) j--;
            if (i<j && i<s.length() && j>=0){
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}
