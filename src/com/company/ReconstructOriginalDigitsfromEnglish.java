package com.company;
// Math
public class ReconstructOriginalDigitsfromEnglish {
    /**
     * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

     Note:
     Input contains only lowercase English letters.
     Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
     Input length is less than 50,000.
     Example 1:
     Input: "owoztneoer"

     Output: "012"
     Example 2:
     Input: "fviefuro"

     Output: "45"
     * @param s
     * @return
     */
    public String originalDigits(String s) {
        int[] count = new int[26];
        int[] res = new int[10];
        for (char c : s.toCharArray()){
            count[c-'a']++;
        }
        if (count['z'-'a']!=0){ // zero
            res[0]+=count['z'-'a'];
            count['e'-'a']-=count['z'-'a'];
            count['r'-'a']-=count['z'-'a'];
            count['o'-'a']-=count['z'-'a'];
            count['z'-'a']=0;
        }
        if (count['w'-'a']!=0){ // two
            res[2]+=count['w'-'a'];
            count['t'-'a']-=count['w'-'a'];
            count['o'-'a']-=count['w'-'a'];
            count['w'-'a']=0;
        }
        if (count['g'-'a']!=0){ // eight;
            res[8]+=count['g'-'a'];
            count['e'-'a']-=count['g'-'a'];
            count['i'-'a']-=count['g'-'a'];
            count['h'-'a']-=count['g'-'a'];
            count['t'-'a']-=count['g'-'a'];
            count['g'-'a']=0;
        }
        if (count['h'-'a']!=0){ // three
            res[3]+=count['h'-'a'];
            count['t'-'a']-=count['h'-'a'];
            count['r'-'a']-=count['h'-'a'];
            count['e'-'a']-=2*count['h'-'a'];
            count['h'-'a']=0;
        }
        if (count['u'-'a']!=0){ //four
            res[4]+=count['u'-'a'];
            count['f'-'a']-=count['u'-'a'];
            count['o'-'a']-=count['u'-'a'];
            count['r'-'a']-=count['u'-'a'];
            count['u'-'a']=0;
        }
        if (count['f'-'a']!=0){ //five
            res[5]+=count['f'-'a'];
            count['i'-'a']-=count['f'-'a'];
            count['v'-'a']-=count['f'-'a'];
            count['e'-'a']-=count['f'-'a'];
            count['f'-'a']=0;
        }
        if (count['v'-'a']!=0){ //seven
            res[7]+=count['v'-'a'];
            count['s'-'a']-=count['v'-'a'];
            count['e'-'a']-=2*count['v'-'a'];
            count['n'-'a']-=count['v'-'a'];
            count['v'-'a']=0;
        }
        if (count['o'-'a']!=0){ //one
            res[1]+=count['o'-'a'];
            count['n'-'a']-=count['o'-'a'];
            count['e'-'a']-=count['o'-'a'];
            count['o'-'a']=0;
        }
        res[6]+=count['x'-'a']; //six
        res[9]+=count['e'-'a']; // nine
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<res.length; ++i){
            int tmp = res[i];
            while (tmp-->0){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
