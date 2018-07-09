package HashTable;
// TAG: Two Pointer, SLiding window
public class PermutationinString {
    /**
     * Given two strings s1 and s2, write a function to return true if s2
     * contains the permutation of s1. In other words, one of the first
     * string's permutations is the substring of the second string.
     Example 1:
     Input:s1 = "ab" s2 = "eidbaooo"
     Output:True
     Explanation: s2 contains one permutation of s1 ("ba").
     Example 2:
     Input:s1= "ab" s2 = "eidboaoo"
     Output: False
     Note:
     The input strings only contain lower case letters.
     The length of both given strings is in range [1, 10,000].

     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        char[] c2 = s2.toCharArray();
        char[] c1 = s1.toCharArray();
        int len = c1.length;
        int [] count = new int[26];
        for (char c : c1){
            count[c-'a']++;
        }
        int i=-1;
        for (int j=0; j<c2.length; ++j){
            if (count[c2[j]-'a']<=0) {
                while (i<j && count[c2[j]-'a']<=0)
                    count[c2[++i]-'a']++;
                j--;
            }
            else count[c2[j]-'a']--;
            //  System.out.println(i+"     "+j);
            if (j-i==len) return true;
        }
        return false;
    }
}
