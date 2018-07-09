package com.company;
// String
public class NumberofSegmentsinaString {
    /**
     * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

     Please note that the string does not contain any non-printable characters.

     Example:

     Input: "Hello, my name is John"
     Output: 5
     * @param s
     * @return
     */
    public int countSegments(String s) {
        int res = 0;
        boolean open = false;
        for (char c : s.toCharArray()){
            if (c!=' ' && !open){
                open=true;
                res++;
            }
            else if (c==' ') open=false;
        }
        return res;
    }
}
