package String;
// String
public class RepeatedSubstringPattern {
    /**
     * Given a non-empty string check if it can be constructed by taking a substring of it
     * and appending multiple copies of the substring together. You may assume the given
     * string consists of lowercase English letters only and its length will not exceed 10000.
     Example 1:
     Input: "abab"

     Output: True

     Explanation: It's the substring "ab" twice.
     Example 2:
     Input: "aba"

     Output: False
     Example 3:
     Input: "abcabcabcabc"

     Output: True

     Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        for (int i=1; i<=s.length()/2; ++i){
            if (s.length()%i!=0) continue;
            String repeat = s.substring(0,i);
            int start = i;
            while (start+i<=s.length()){
                //if (start+i>s.length()) break;
                if (s.substring(start, start+i).equals(repeat)) {
                    start = start+i;
                }
                else break;
            }
            if (start==s.length()) return true;
        }
        return false;
    }


   // return (s+s).substring(1, 2*s.length()-1).indexOf(s)!=-1;
}
