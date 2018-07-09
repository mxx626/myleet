package HashTable;
// HashTable
public class IsomorphicStrings {
    /**
     * Given two strings s and t, determine if they are isomorphic.

     Two strings are isomorphic if the characters in s can be replaced to get t.

     All occurrences of a character must be replaced with another character while
     preserving the order of characters. No two characters may map to the same
     character but a character may map to itself.

     Example 1:

     Input: s = "egg", t = "add"
     Output: true
     Example 2:

     Input: s = "foo", t = "bar"
     Output: false
     Example 3:

     Input: s = "paper", t = "title"
     Output: true
     Note:
     You may assume both s and t have the same length.
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        int[] count1 = new int[256];
        int[] count2 = new int[256];
        for (int i=0; i<s.length(); ++i){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (count1[sc]!=count2[tc]) return false;
            count1[sc] = i+1;
            count2[tc] = i+1;
        }

        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        int[] count1 = new int[256];
        int[] count2 = new int[256];
        for (int i=0; i<s.length(); ++i){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (count1[sc]!=0){
                if (count1[sc]!=tc) return false;
            }
            else if (count2[tc]!=0){
                return false;
            }
            else {
                count1[sc]=tc;
                count2[tc]=sc;
            }
        }

        return true;
    }
}
