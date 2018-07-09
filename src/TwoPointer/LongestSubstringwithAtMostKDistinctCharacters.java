package TwoPointer;
// Two Pointer
public class LongestSubstringwithAtMostKDistinctCharacters {
    /**
     * Given a string, find the length of the longest substring T that contains at most k distinct characters.

     For example, Given s = “eceba” and k = 2,

     T is "ece" which its length is 3.
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k==0) return 0;
        if (s.length()<=k) return s.length();
        int[] count = new int[256];
        int i=0;
        int c=0;
        int res=0;
        for (int j=0; j<s.length(); ++j){
            char cur = s.charAt(j);
            if (c<=k){
                if (count[cur]==0) c++;
                count[cur]++;
            }

            if (c>k || j==s.length()-1){
                while (i<s.length() && c>k){
                    char del = s.charAt(i);
                    count[del]--;
                    if (count[del]==0) c--;
                    i++;
                }
            }
            res = Math.max(res, j-i+1);
        }
        return res;
    }

    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        if (s == null) return 0;
        if (s.length() < k) return s.length();
        int[] count = new int[256];
        int left = 0, maxLen = 0, unique = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (count[ch]++ == 0) unique++;
            while (unique > k) {
                char lf = s.charAt(left);
                if (count[lf]-- == 1) unique--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
