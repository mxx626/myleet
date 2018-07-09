package com.company;
// String, Two Pointer
/**
 * 344. Reverse String

 Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".


 */
public class ReverseString {
    public String reverseString(String s) {
        if (s==null || s.length()<=1) return s;
        char[] arr = s.toCharArray();
        int i=0, j=s.length()-1;
        while (i<j){
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        return new String(arr);
    }
}
