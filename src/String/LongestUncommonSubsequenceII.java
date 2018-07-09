package String;
// TAG: String
import java.util.Comparator;
import java.util.Arrays;
public class LongestUncommonSubsequenceII {
    /**
     * Given a list of strings, you need to find the longest uncommon subsequence among them.
     * The longest uncommon subsequence is defined as the longest subsequence of one of these
     * strings and this subsequence should not be any subsequence of the other strings.

     A subsequence is a sequence that can be derived from one sequence by deleting some characters
     without changing the order of the remaining elements. Trivially, any string is a subsequence
     of itself and an empty string is a subsequence of any string.

     The input will be a list of strings, and the output needs to be the length of the longest
     uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

     Example 1:
     Input: "aba", "cdc", "eae"
     Output: 3
     Note:

     All the given strings' lengths will not exceed 10.
     The length of the given list will be in the range of [2, 50].
     * @param strs
     * @return
     */
    public int findLUSlength(String[] strs) {
        if (strs.length==0 || strs.length==1) return strs.length;
        Arrays.sort(strs, new Comparator<String>(){
            @Override
            public  int compare(String o1, String o2){
                return o2.length()-o1.length();
            }
        });
        for (int i=0; i<strs.length; ++i){
            boolean flag = true;
            for (int j=0;j<strs.length; ++j){
                if (i==j) continue;
                if (isSubseq(strs[j], strs[i])){
                    flag=false;
                    break;
                }
            }
            if (flag) return strs[i].length();
        }
        return -1;
    }
    private boolean isSubseq(String p, String c){
        int i=0, j=0;
        while (i<p.length() && j<c.length()){
            if (p.charAt(i)==c.charAt(j)) j++;
            i++;
        }
        return j==c.length();
    }
}
