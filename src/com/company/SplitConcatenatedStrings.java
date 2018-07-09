package com.company;
// TAG: String
public class SplitConcatenatedStrings {
    /**
     * Given a list of strings, you could concatenate these strings together into
     * a loop, where for each string you could choose to reverse it or not. Among
     * all the possible loops, you need to find the lexicographically biggest string
     * after cutting the loop, which will make the looped string into a regular one.

     Specifically, to find the lexicographically biggest string, you need to experience two phases:

     Concatenate all the strings into a loop, where you can reverse some strings or not
     and connect them in the same order as given.
     Cut and make one breakpoint in any place of the loop, which will make the looped s
     tring into a regular one starting from the character at the cutpoint.
     And your job is to find the lexicographically biggest one among all the possible
     regular strings.

     Example:
     Input: "abc", "xyz"
     Output: "zyxcba"
     Explanation: You can get the looped string "-abcxyz-", "-abczyx-", "-cbaxyz-", "-cbazyx-",
     where '-' represents the looped status.
     The answer string came from the fourth looped one,
     where you could cut from the middle character 'a' and get "zyxcba".
     Note:
     The input strings will only contain lowercase letters.
     The total length of all the strings will not over 1,000.
     * @param strs
     * @return
     */
    public String splitLoopedString(String[] strs) {
        for (int i=0; i<strs.length; ++i){
            String re = new StringBuilder(strs[i]).reverse().toString();
            if (strs[i].compareTo(re)<0){
                strs[i]=re;
            }
        }
        String res = "a";
        for (int i=0; i<strs.length; ++i){
            String re = new StringBuilder(strs[i]).reverse().toString();
            for (String s : new String[]{strs[i], re}){
                for (int j=0; j<s.length(); ++j){
                    if (s.charAt(j) >= res.charAt(0)) {
                        StringBuilder sb = new StringBuilder(s.substring(j));
                        for (int m=i+1; m<strs.length; ++m){
                            sb.append(strs[m]);
                        }
                        for (int n=0; n<i; n++){
                            sb.append(strs[n]);
                        }
                        sb.append(s.substring(0, j));
                        if (sb.toString().compareTo(res)>0){
                            res = sb.toString();
                        }
                    }
                }
            }
        }
        return res;
    }
}
