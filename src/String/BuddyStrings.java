package String;
// String
/**
 * 859. Buddy Strings

 Given two strings A and B of lowercase letters, return true if and
 only if we can swap two letters in A so that the result equals B.

 Example 1:
 Input: A = "ab", B = "ba"
 Output: true
 Example 2:

 Input: A = "ab", B = "ab"
 Output: false
 Example 3:

 Input: A = "aa", B = "aa"
 Output: true
 Example 4:

 Input: A = "aaaaaaabc", B = "aaaaaaacb"
 Output: true
 Example 5:

 Input: A = "", B = "aa"
 Output: false


 Note:

 0 <= A.length <= 20000
 0 <= B.length <= 20000
 A and B consist only of lowercase letters.
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length()!=B.length()) return false;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int first = -1, second = -1;
        for (int i=0; i<A.length(); ++i){
            if (a[i]!=b[i]){
                if (first==-1){
                    first = i;
                }
                else if (second==-1){
                    second = i;
                }
                else return false;
            }

        }
        if (first!=-1 && second!=-1 && a[second]==b[first] && a[first]==b[second]) return true;
        if (first*second<0) return false;
        if (first==-1 && second==-1){
            if (dup(a,b)) return true;
        }
        return false;
    }
    private boolean dup (char[] a, char[] b){
        int[] ca = new int[26];
        int[] cb = new int[26];
        for (int i=0; i<a.length; ++i){
            ca[a[i]-'a']++;
            cb[b[i]-'a']++;
        }
        for (int i=0; i<ca.length; ++i){
            if (ca[i]>=2 && cb[i]>=2){
                return true;
            }
        }
        return false;
    }
}
