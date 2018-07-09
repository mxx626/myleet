package com.company;
// String
public class LengthofLastWord {
    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

     If the last word does not exist, return 0.

     Note: A word is defined as a character sequence consists of non-space characters only.

     Example:

     Input: "Hello World"
     Output: 5
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s==null || s.length()==0) return 0;
        int res = 0;
        boolean flag = s.charAt(s.length()-1)==' ';
        for  (int i=s.length()-1; i>=0; --i){
            if (s.charAt(i)!=' '){
                flag=false;
            }
            if  (!flag && s.charAt(i)!=' '){
                res++;
            }
            else if (!flag && s.charAt(i)==' ') break;
        }
        return res;
    }
}
