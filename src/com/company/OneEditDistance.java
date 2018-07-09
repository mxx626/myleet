package com.company;
// TAG: String
public class OneEditDistance {
    /**
     * Given two strings S and T, determine if they are both one edit distance apart.
     * @param s
     * @param t
     * @return
     */
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) return false;
        for (int i=0; i<Math.min(s.length(), t.length()); ++i){
            if (s.charAt(i)!=t.charAt(i)){
                if (s.length()==t.length())
                    return s.substring(i+1).equals(t.substring(i+1));
                else if (s.length()>t.length()){
                    return s.substring(i+1).equals(t.substring(i));
                }
                else return s.substring(i).equals(t.substring(i+1));
            }
        }
        return Math.abs(s.length()-t.length())==1;
    }

    public boolean isOneEditDistance2(String s, String t) {
        if (s.equals(t) || Math.abs(s.length()-t.length())>1) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int i=0, j=0;
        int count=0;
        for (i=0, j=0; i<s.length()&&j<t.length();){
            if (s1[i]!=t1[j]){
                if (count!=0) return false;
                else {
                    if(s1.length==t1.length){
                        i++;
                        j++;
                    }
                    else if (s1.length>t1.length) i++;
                    else j++;
                }
                count++;
            }
            else {
                i++;
                j++;
            }
        }
        return true;
    }
}
