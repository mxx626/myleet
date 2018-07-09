package HashTable;
// HashTable
public class PalindromePermutation {
    /**
     * Given a string, determine if a permutation of the string could form a palindrome.

     Example 1:

     Input: "code"
     Output: false
     Example 2:

     Input: "aab"
     Output: true
     Example 3:

     Input: "carerac"
     Output: true
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        char[] ch = s.toCharArray();
        int[] count = new int[128];
        for (char c : ch) count[c]++;
        boolean single = false;
        for (int i : count){
            if (i%2==0) continue;
            else if (i%2==1){
                if (single) return false;
                single=true;
            }
        }
        return true;
    }
}
